package com.gif.eting.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gif.eting.dto.User;

public interface UserMapper {
	@Select("SELECT * FROM user_info WHERE user_id = #{user_id}")
	public User getUserInfo(@Param("user_id") String userId);
	
}
