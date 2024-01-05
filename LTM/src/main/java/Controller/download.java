package Controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spire.pdf.exporting.xps.schema.Path;

import Model.BEAN.uploadfile;
import Model.BO.DownloadFileBO;


@WebServlet("/download")
public class download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public download() {
        super();
       
    }

	

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        String relativePath = "/file/abc4.pdf";
        String fullPath = context.getRealPath(relativePath);

        if (fullPath == null) {
            // Xử lý đường dẫn null
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        File file = new File(fullPath);

        if (!file.exists() || !file.isFile()) {
            // Xử lý tệp tin không tồn tại hoặc không phải là tệp tin
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        byte[] data = Files.readAllBytes(file.toPath());

        // Thiết lập thông tin trả về
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment; filename=abc4.pdf");
        response.setContentLength(data.length);

        try (OutputStream outStream = response.getOutputStream()) {
            outStream.write(data);
            outStream.flush();
        }
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
    }





}
