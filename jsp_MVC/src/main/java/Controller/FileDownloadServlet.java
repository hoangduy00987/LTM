package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Đường dẫn tới thư mục chứa tệp tin tải lên
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";

        // Tên tệp tin cần tải xuống
        String fileName = "example.txt";

        // Đường dẫn tới tệp tin cần tải xuống
        String filePath = uploadPath + File.separator + fileName;

        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);

        // Thiết lập các thông tin phản hồi HTTP
        response.setContentType("application/octet-stream");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        // Ghi dữ liệu từ FileInputStream vào OutputStream của phản hồi
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            response.getOutputStream().write(buffer, 0, bytesRead);
        }
        fis.close();
    }
}