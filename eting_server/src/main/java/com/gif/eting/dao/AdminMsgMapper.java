package com.gif.eting.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gif.eting.dto.AdminMsg;

public interface AdminMsgMapper {
	@Select("SELECT * FROM admin_msg WHERE msg_id = #{msg_id}")
	public AdminMsg getAdminMsgInfo(@Param("msg_id") String msgId);

	//메세지 등록
	public int insAdminMsg(AdminMsg adminMsg);
	
	//코멘트 등록
	public int insAdminMsgComment(AdminMsg adminMsg);
}
