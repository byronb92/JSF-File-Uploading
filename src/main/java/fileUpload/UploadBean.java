/*
 * Created by Byron Becker on 2014.10.28  * 
 * Copyright © 2014 Byron Becker. All rights reserved. * 
 */
package fileUpload;

import java.io.IOException;
import java.io.InputStream;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author byronb92
 */
@Named(value = "uploadBean")
@ManagedBean("uploadBean")  
@SessionScoped
public class UploadBean implements Serializable {
    
    private Part file1;
    private InputStream file1Stream;

    public InputStream getFile1Stream() {
        return file1Stream;
    }

    public void setFile1Stream(InputStream file1Stream) {
        this.file1Stream = file1Stream;
    }

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public Part getFile2() {
        return file2;
    }

    public void setFile2(Part file2) {
        this.file2 = file2;
    }
    private Part file2;
        
    public String upload() throws IOException {
        
        // Store file's input stream.
        setFile1Stream(file1.getInputStream());
        // This string is the name of the actual file.
        return "SuccessUpload";
    }
    
    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"","");
//                return filename.substring(filename.lastIndexOf('/') + 1).substring(
//                        filename.lastIndexOf('\\') + 1);
                return filename;
            }
        }
        return null;
    }
    /**
     * Creates a new instance of UploadBean
     */
    public UploadBean() {
        

    }
}
