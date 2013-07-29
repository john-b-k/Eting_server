package com.gif.eting.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import com.gif.eting.dao.EtingDAO;
import com.gif.eting.vo.EtingVO;
import com.gif.eting.vo.StampVO;

@Controller
public class MainController {
	Logger log = LoggerFactory.getLogger(MainController.class);

	@Autowired
	@Qualifier(value = "jsonView")
	private View jsonView;

	@Autowired
	EtingDAO etingDao;

	/*
	 * 테스트
	 */
	@RequestMapping(value = "/test")
	public View test(Model model) {
		// 답사 기본정보 목록조회
		model.addAttribute("return", "123");
		return jsonView;
	}

	// 처음페이지 - 암호해제
	@RequestMapping(value = "/")
	public String intro() {

		return "intro";
	}

	// 메인페이지
	@RequestMapping(value = "/main")
	public String main(HttpServletRequest request) {
		String phoneId = request.getParameter("phoneId");
		log.debug("phoneId = " + phoneId);
		HttpSession session = request.getSession(true);
		session.setAttribute("phoneId", phoneId); // 세션에 phoneId 저장

		EtingVO sm = new EtingVO();
		sm.setPhone_id(phoneId);
		List<EtingVO> list = etingDao.getStoryFromRecieved(sm);
		request.setAttribute("list", list);

		List<StampVO> stampList = etingDao.getStamp();
		request.setAttribute("stampList", stampList);

		return "main";
	}

	// 이야기 입력 화면
	@RequestMapping(value = "/write")
	public String input() {

		return "write";
	}

	// 이야기 저장하기
	// 1. 이야기를 저장한 후 (story_master),
	// 2. 보내질 이야기 대기열에 넣고 (story_queue),
	// 3. 대기열에서 이야기를 가져온다 (story_queue),
	// 4. 가져온 이야기는 대기열에서 삭제한다. (story_queue),
	// 5. 가져온 이야기를 자신의 받은이야기함에 넣는다.(recieved_story)
	@RequestMapping(value = "/insert")
	public String insert(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String phoneId = (String) session.getAttribute("phoneId");
		String content = request.getParameter("content");

		EtingVO sm = new EtingVO();
		sm.setPhone_id(phoneId);
		sm.setContent(content);

		etingDao.insEtingVO(sm); // 1. 이야기저장
		etingDao.insStoryQueue(sm); // 2. 이야기대기열에 저장

		sm = etingDao.getStoryFromQueue(sm); // 3. 대기열에서 이야기를 가져온다

		// 받아온게 있으면
		if (sm != null) {
			etingDao.delStoryFromQueue(sm);
			sm.setPhone_id(phoneId);
			etingDao.insRecievedStory(sm); // 5.대기열에서 가져온 이야기가 있으면 받은이야기함에 넣는다.
		} else {
			sm = new EtingVO();
			sm.setPhone_id(phoneId);
		}

		// 자기 이야기 목록 받아오기
		setStoryList(request, sm);
		return "list"; // 이야기를 등록하고 목록화면으로 이동
	}

	// 이야기 목록 화면
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String phoneId = (String) session.getAttribute("phoneId");
		EtingVO sm = new EtingVO();
		sm.setPhone_id(phoneId);

		// 자기 이야기 목록 받아오기
		setStoryList(request, sm);
		return "list";
	}

	// 자기이야기 목록
	public void setStoryList(HttpServletRequest request, EtingVO sm) {
		List<EtingVO> list = etingDao.getEtingVOList(sm);
		request.setAttribute("list", list);
	}

	// 스탬프찍기
	// 스탬프 찍고난 후 해당 스토리를 받은이야기함에서 지우기
	@RequestMapping(value = "/stamp")
	public String stamp(HttpServletRequest request) {
		String storyId = request.getParameter("storyId");
		String stampId = request.getParameter("stampId");

		StampVO sm = new StampVO();
		sm.setStamp_id(stampId);
		sm.setStory_id(storyId);

		etingDao.insStampToStory(sm); // 스탬프찍기
		etingDao.delStoryFromRecieved(sm); // 스탬프찍은 이야기를 받음이야기함에서 지우기

		return this.main(request);
	}

}
