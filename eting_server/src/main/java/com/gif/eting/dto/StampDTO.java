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
	private String comment;
	private String stamps;
	
	

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("story_id=");
		sb.append(story_id);
		sb.append("|");
				
		sb.append("stamps=");
		sb.append(stamps);
		sb.append("|");
				
		sb.append("comment=");
		sb.append(comment);
		sb.append("|");
			
		return sb.toString();
	}

	public String getStamps() {
		return stamps;
	}

	public void setStamps(String stamps) {
		this.stamps = stamps;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
