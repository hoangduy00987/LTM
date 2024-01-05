package Model.BEAN;

public class Tour {
	public int id;

	private String location;
	private String description;
	private String number_day;
	private String image;
    private String price;
    String video_link;
    String detail_description;
	public String getVideo_link() {
		return video_link;
	}

	public void setVideo_link(String video_link) {
		this.video_link = video_link;
	}

	public String getDetail_description() {
		return detail_description;
	}

	public void setDetail_description(String detail_description) {
		this.detail_description = detail_description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNumber_day() {
		return number_day;
	}

	public void setNumber_day(String number_day) {
		this.number_day = number_day;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
