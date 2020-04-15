package org.bestsoft.controller.v1;

import org.bestsoft.utils.ExcelExportor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;


@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MainServiceController {

    @Autowired
    ExcelExportor excelExportor;

//    @Value("${file.download.path}")
    String path;

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse response) throws IOException {
        String fileName = "output.xls";
        download(path + fileName, response);
    }

    public void download(String path, HttpServletResponse response) {
        try {
            if (path != null && !path.equals("")) {
                File file = new File(path);
                String fileName = file.getName();
                InputStream fis = new BufferedInputStream(new FileInputStream(path));
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fis.close();
                response.reset();
                String uncod = URLDecoder.decode(fileName, "UTF-8");
                fileName = new String(uncod.getBytes("UTF-8"), "iso-8859-1");
                response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(fileName)));
                response.addHeader("Content-Length", "" + file.length());
                response.addHeader("Access-Control-Allow-Origin", "*");
                response.addHeader("Content-type", "application/x-download;charset:utf-8");
                OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
                toClient.write(buffer);
                toClient.flush();
                toClient.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
