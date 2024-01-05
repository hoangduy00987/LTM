package Model.BEAN;

public class Comment {
	String name_user;
	String content_comment;
	
	public void setComment(String comment) {
		this.content_comment = comment;
	}
	public String getComment() {
		return this.content_comment;
	}
	
	public String get_nameuser() {
		return this.name_user;
	}
	public void set_nameuser(String name_user) {
		this.name_user = name_user;
	}
}
