package br.com.romalopes.springexamples.romaSpringUploadFile;

import org.springframework.core.io.FileSystemResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 06/11/13
 * Time: 10:35
 * To change this template use File | Settings | File Templates.
 */
public class FileUploader {

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) {
            System.out.println("Usage: Requires the name of a file to upload.");
            System.exit(1);
        }

        String file = args[0];//"C:\\Anderson\\Estudo_Geral\\GeneralStudies\\SpringExamples.txt";
        RestTemplate template = new RestTemplate();
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
        parts.add("name", file);
        parts.add("file", new FileSystemResource(file));
        //call upload using POST
        String response = template.postForObject("http://localhost:8080/upload", parts, String.class);
        System.out.println(response);
    }

}