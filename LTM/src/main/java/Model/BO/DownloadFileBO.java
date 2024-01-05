package Model.BO;

import Model.BEAN.uploadfile;
import Model.DAO.DownloadFileDAO;

public class DownloadFileBO {
	 DownloadFileDAO download = new DownloadFileDAO();
	public  uploadfile GetFile(int fid) {
		return download.GetFile(fid);
	}
}
