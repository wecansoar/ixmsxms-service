package net.flower.ixmsxms.service.controller;

import net.flower.ixmsxms.service.domain.UploadImageFile;
import net.flower.ixmsxms.service.domain.User;
import net.flower.ixmsxms.service.service.UploadService;
import net.flower.ixmsxms.service.service.UserService;
import net.flower.ixmsxms.service.utils.JSonResultMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Resource
    private UploadService uploadService;

    @Resource
    private UserService userService;

    @RequestMapping("/index")
	public String index() {
        return "index";
	}


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    @SuppressWarnings("rawtypes")
    @JSonResultMapping
    public Object upload( HttpServletRequest request, UploadImageFile uploadImageFile, User user) throws Exception {
        return this.uploadService.upload(request, uploadImageFile, user);
    }

    @RequestMapping("/error/{code}")
    public String error(HttpServletRequest request, @PathVariable("code") String code) {
        System.out.println("error----------" + code);
        request.setAttribute("code", code);
        return "error";
    }
}