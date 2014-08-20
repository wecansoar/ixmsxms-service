package net.flower.ixmsxms.service.controller;

import net.flower.ixmsxms.service.domain.Child;
import net.flower.ixmsxms.service.service.ChildService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/child")
public class ChildController extends DefaultController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ChildService childService;

    @RequestMapping(value="/list", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object list(Child child) {
        return this.childService.selectListByUserId(child);
    }

    @RequestMapping(value="/{childId}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Child view(@PathVariable("childId") Long childId){
        return this.childService.select(childId);
    }

    @RequestMapping(value="/add", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object add(@RequestBody Child child) {
        return this.childService.insert(child);
    }

    @RequestMapping(value="/{childId}", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object edit(@RequestBody Child child) {
        return this.childService.update(child);
    }

    @RequestMapping(value="/{childId}", method=RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object delete(@PathVariable("childId") Long childId) {
        return this.childService.delete(childId);
    }
}