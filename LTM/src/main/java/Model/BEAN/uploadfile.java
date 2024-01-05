package Model.BEAN;

public class uploadfile {
public int id_file;
public String slug;
public int getId_file() {
	return id_file;
}
public void setId_file(int id_file) {
	this.id_file = id_file;
}
public String getSlug() {
	return slug;
}
public void setSlug(String slug) {
	this.slug = slug;
}
public uploadfile(int id, String slug) {
	super();
	this.id_file = id;
	this.slug = slug;
	
}
public uploadfile() {
	super();
	
}
}
