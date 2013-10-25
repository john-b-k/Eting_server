package com.gif.eting.dto;

public class StoryDTO {

	public StoryDTO() {
	}

	private String story_id;
	private String content;
	private String phone_id;
	private String story_date;
	private String story_time;
	private String stamp_name;

	
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("story_id=");
		sb.append(story_id);
		sb.append("|");
		
		sb.append("content=");
		sb.append(content);
		sb.append("|");
		
		sb.append("phone_id=");
		sb.append(phone_id);
		sb.append("|");
		
		sb.append("story_date=");
		sb.append(story_date);
		sb.append("|");
		
		sb.append("story_time=");
		sb.append(story_time);
		sb.append("|");
		
		return sb.toString();
	}

	public String getStory_time() {
		return story_time;
	}

	public void setStory_time(String story_time) {
		this.story_time = story_time;
	}

	public String getStamp_name() {
		return stamp_name;
	}

	public void setStamp_name(String stamp_name) {
		this.stamp_name = stamp_name;
	}

	public String getStory_id() {
		return story_id;
	}

	public void setStory_id(String story_id) {
		this.story_id = story_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhone_id() {
		return phone_id;
	}

	public void setPhone_id(String phone_id) {
		this.phone_id = phone_id;
	}

	public String getStory_date() {
		return story_date;
	}

	public void setStory_date(String story_date) {
		this.story_date = story_date;
	}

}
