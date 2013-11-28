package br.com.romalopes.springexamples.detectdevice;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 06/11/13
 * Time: 00:44
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class DeviceDetectionController {

    @RequestMapping("/detect-device")
     public @ResponseBody   //<----  Tells MVC to write and returns object rather than render a model into view.
    String detectDevice(Device device) {  //<-- Spring knows which kind of device is sending request.
        String deviceType = "unknown";
        if (device.isNormal()) {
            deviceType = "normal";
        } else if (device.isMobile()) {
            deviceType = "mobile";
        } else if (device.isTablet()) {
            deviceType = "tablet";
        }
        return "Hello " + deviceType + " browser!";  //<--Simple returns a string, not a jsp.
    }
}