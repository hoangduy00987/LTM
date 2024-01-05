package Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Model.BO.UploadFileBO;
@WebServlet("/UploadFileServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 500) // 500MB
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadFileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String destination = null;

        Part part = request.getPart("file");
        String fileName = extractFileName(part);
        getServletContext().setAttribute("filename", fileName);
       
        String uploadPath = "D:/java_web/workspace/LTM/src/main/webapp/file"; // Đường dẫn tuyệt đối đến thư mục lưu trữ file
        
        File fileUploadDirectory = new File(uploadPath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdirs();
        }
        String savePath = uploadPath + File.separator + fileName;
        part.write(savePath);
        UploadFileBO file = new UploadFileBO();
//        String idUser = request.getParameter("idUser");
        
        String idUser = (String)getServletContext().getAttribute("idUser");
      
        // Gọi hàm truy vấn ở file khác để chèn dữ liệu vào CSDL
        boolean insertSuccess = file.uploadFile(fileName, idUser);

        if (insertSuccess) {
            destination = "/HomePage.jsp";
            RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
            rd.forward(request, response);
        } else {
            out.println("<center><h1>Error occurred while adding file.</h1></center>");
        }
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
