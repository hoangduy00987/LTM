<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
        <title>File Upload</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            .main{
                width: 300px;
                height: 200px;
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                text-align: center;
                border: 2px solid;
            }
            form{
                width: 100%;
                position: relative;
                display: block;
                margin: 20px auto;
            }
            input{
                margin: 10px 0;
            }

        </style>
    </head>
    
    <body>
       
        <div class="main">
            <form method="POST" action="FileUploadServlet" enctype="multipart/form-data" >
                <input type="file" name="file" accept=".docx"/>
                <input type="submit" value="Upload"/>
            </form>
            <div class="downlaod">
                <span>1. File Name: Chart.png <a href="FileDownloadServlet">Download</a></span>
            </div>
        </div>
    </body>
</html>

</body>

