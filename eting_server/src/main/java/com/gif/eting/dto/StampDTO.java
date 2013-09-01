package com.gif.eting.dto;

public class StampDTO {

	public StampDTO() {
	}

	private String story_id;
	private String stamp_id;
	private String stamp_name;
	private String stamp_url;
	private String stamp_type;
	private String stamp_order;
	private String sender;

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getStamp_type() {
		return stamp_type;
	}

	public void setStamp_type(String stamp_type) {
		this.stamp_type = stamp_type;
	}

	public String getStamp_order() {
		return stamp_order;
	}

	public void setStamp_order(String stamp_order) {
		this.stamp_order = stamp_order;
	}

	public String getStory_id() {
		return story_id;
	}

	public void setStory_id(String story_id) {
		this.story_id = story_id;
	}

	public String getStamp_id() {
		return stamp_id;
	}

	public void setStamp_id(String stamp_id) {
		this.stamp_id = stamp_id;
	}

	public String getStamp_name() {
		return stamp_name;
	}

	public void setStamp_name(String stamp_name) {
		this.stamp_name = stamp_name;
	}

	public String getStamp_url() {
		return stamp_url;
	}

	public void setStamp_url(String stamp_url) {
		this.stamp_url = stamp_url;
	}

}
