package Model.BO;

import Model.BEAN.uploadfile;

public class getFile {
	
	getFile getf = new getFile();
	public uploadfile getFileName(String filename){
		return getf.GetFile(filename);
	}
}
