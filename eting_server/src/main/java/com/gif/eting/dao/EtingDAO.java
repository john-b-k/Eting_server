package com.gif.eting.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gif.eting.vo.EtingVO;
import com.gif.eting.vo.StampVO;

public interface EtingDAO {
	@Select("SELECT * FROM gif_story_story_master WHERE story_id = #{story_id}")
	public EtingVO getEtingVO(@Param("story_id") int storyId);

	/*
	 * 이야기 목록 조회
	 */
	public List<EtingVO> getEtingVOList(EtingVO etingVo);

	/*
	 * 이야기 등록
	 */
	public int insEtingVO(EtingVO etingVo);

	/*
	 * 이야기 수정
	 */
	public int updEtingVO(EtingVO etingVo);

	/*
	 * 이야기 삭제
	 */
	public int delEtingVO(EtingVO etingVo);

	/*
	 * 이야기 대기열에 이야기 등록
	 */
	public int insStoryQueue(EtingVO etingVo);

	/*
	 * 대기열에서 이야기를 받아온다
	 */
	public EtingVO getStoryFromQueue(EtingVO etingVo);

	/*
	 * 대기열에서 받아온 이야기는 대기열에서 삭제
	 */
	public int delStoryFromQueue(EtingVO etingVo);

	/*
	 * 받은이야기함에 등록
	 */
	public int insRecievedStory(EtingVO etingVo);

	/*
	 * 받은이야기함에서 불러오기
	 */
	public List<EtingVO> getStoryFromRecieved(EtingVO etingVo);

	/*
	 * 사용가능한 스탬프 불러오기
	 */
	public List<StampVO> getStamp();

	/*
	 * 스탬프찍기
	 */
	public int insStampToStory(StampVO stampVO);

	/*
	 * 스탬프찍은 이야기를 받은이야기함에서 지우기
	 */
	public int delStoryFromRecieved(StampVO stampVO);

}
