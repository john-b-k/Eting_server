package com.gif.eting.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PhoneDTO {
	private String phone_id;
	private String reg_id;
	private String os;
	
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("phone_id=");
		sb.append(phone_id);
		sb.append("|");
		
		sb.append("reg_id=");
		sb.append(reg_id);
		sb.append("|");
		
		java.util.Date d = new java.util.Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		String date = df.format(d);
		
		sb.append("date=");
		sb.append(date);
		sb.append("|");
		
		long t = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("hh:mm:ss");
		String time = dayTime.format(new Date(t));
		
		sb.append("time=");
		sb.append(time);
		sb.append("|");
		
		return sb.toString();
	}

	public String getPhone_id() {
		return phone_id;
	}

	public void setPhone_id(String phone_id) {
		this.phone_id = phone_id;
	}

	public String getReg_id() {
		return reg_id;
	}

	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}
	
	

}
