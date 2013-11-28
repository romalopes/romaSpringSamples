package br.com.romalopes.springexamples.romaSpringUploadFile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 06/11/13
 * Time: 09:01
 * To change this template use File | Settings | File Templates.
 */
@Controller         //Make this class a controller to receive requests.
public class UploadFileController {

    @RequestMapping(value="/upload", method= RequestMethod.GET)     //The Methods for requests.
    public @ResponseBody
    String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }

    @RequestMapping(value="/upload", method=RequestMethod.POST)   //The Methods for requests.
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,         //Request parameters
                                        @RequestParam("file") MultipartFile file){ //Request parameter that is a file.
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

}