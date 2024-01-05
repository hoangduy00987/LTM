package Model.BO;



import Model.DAO.UploadFileDAO;



public class UploadFileBO {
	UploadFileDAO funcDAO = new UploadFileDAO();
	public boolean uploadFile(String slug, String idUser) {
		return funcDAO.uploadFile(slug, idUser);
		
	}

}
