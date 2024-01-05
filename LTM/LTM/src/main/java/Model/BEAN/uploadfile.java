package Model.BEAN;

public class uploadfile {
public String id_file;
public String slug;
public String getId_file() {
	return id_file;
}
public void setId_file(String id_file) {
	this.id_file = id_file;
}
public String getSlug() {
	return slug;
}
public void setSlug(String slug) {
	this.slug = slug;
}
public uploadfile(String id, String slug) {
	super();
	this.id_file = id;
	this.slug = slug;
	
}
public uploadfile() {
	super();
	
}
}
