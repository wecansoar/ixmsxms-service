package net.flower.ixmsxms.service.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.flower.ixmsxms.service.domain.AuthenticationDevice;
import net.flower.ixmsxms.service.service.AuthenticationDeviceService;
import net.flower.ixmsxms.service.utils.JSonResultMapping;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.flower.ixmsxms.service.domain.User;
import net.flower.ixmsxms.service.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends DefaultController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserService userService;

    @RequestMapping("/authentication")
    @ResponseBody
    public Object authentication(@RequestBody User user){
        return this.userService.authentication(user);
    }

    @RequestMapping(value="/{userId}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object view(@PathVariable("userId") Long userId, User user, AuthenticationDevice authenticationDevice) {
        user.setAuthenticationDevice(authenticationDevice);
        System.out.println("VIOLET ");
        System.out.println(user);
        return this.userService.select(user);
    }

    @RequestMapping(value="/add", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object add(@RequestBody User user) {
        return this.userService.insert(user);
    }

    @RequestMapping(value="/{userId}", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object edit(@PathVariable("userId") Long userId, @RequestBody User user) {
        user.setUserStatus("JOIN");
        return this.userService.update(user);
    }

    @RequestMapping(value="/login", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object editLogin(User user) {
        return this.userService.updateLastLogin(user);
    }

    @RequestMapping(value="/{userId}", method=RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object delete(@PathVariable("userId") Long userId, User user) {
        return this.userService.delete(user);
    }

}