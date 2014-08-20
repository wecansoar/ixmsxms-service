package net.flower.ixmsxms.service.controller;


import net.flower.ixmsxms.service.domain.AverageGrowthTable;
import net.flower.ixmsxms.service.domain.Growth;
import net.flower.ixmsxms.service.domain.GrowthChildMap;
import net.flower.ixmsxms.service.domain.GrowthItem;
import net.flower.ixmsxms.service.service.AverageGrowthTableService;
import net.flower.ixmsxms.service.service.GrowthItemService;
import net.flower.ixmsxms.service.service.GrowthService;
import net.flower.ixmsxms.service.utils.CoreUtil;
import org.apache.commons.lang.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.util.resources.CalendarData;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
@RequestMapping("/growth")
public class GrowthController extends DefaultController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private GrowthService growthService;

    @Resource
    private GrowthItemService growthItemService;

    @Resource
    private AverageGrowthTableService averageGrowthTableService;


    @RequestMapping(value="/{growthId}", method=RequestMethod.GET)
    @ResponseBody
    public Object view(@PathVariable("growthId") Long growthId ,  Growth growth) {
//        growth.setGrowthId(growthId);
        return this.growthService.selectByGrowthId(growthId);
    }

    @RequestMapping(value="/list", method=RequestMethod.GET)
    @ResponseBody
    public Object list(Growth growth) {
        return this.growthService.selectListByUserId(growth);
    }

    @RequestMapping(value="/{type}/photo/list/{childId}", method=RequestMethod.GET)
    @ResponseBody
    public Object photo(@PathVariable("type") String type, @PathVariable("childId") Long childId, GrowthChildMap growthChildMap) {
        if( !type.equals("user") && !type.equals("child")){
            this.logger.debug("@@@@ type error");
            throw new IllegalArgumentException("type");
        }
        growthChildMap.setChildId(childId);
        if( type.equals("child") ){
            return this.growthItemService.selectListPhotoByUserId(growthChildMap);
        }else{
            return this.growthItemService.selectListPhotoByUserId(growthChildMap);
        }

    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody Growth growth, @RequestBody List<GrowthChildMap> growthChildMaps, @RequestBody List<GrowthItem> growthItems) {
        if( growth.getUserId().equals("") ){
            this.logger.debug("@@@@ userId required");
            throw new IllegalArgumentException("UserID");
        }
        return this.growthService.insert(growth, growthChildMaps, growthItems);
    }

    @RequestMapping(value="/average/{sex}/{months}")
    @ResponseBody
    public Object view(@PathVariable("months") String months, @PathVariable("sex") String sex) {
        System.out.println("@@@@violet" );
        System.out.println(sex );
//        if( sex != "M" &&  sex != "F" ){
//            this.logger.debug("@@@@ sex required");
//            throw new IllegalArgumentException("sex");
//        }

        AverageGrowthTable averageGrowthTable = new AverageGrowthTable();
        averageGrowthTable.setSex(sex);

        if( Integer.parseInt(months) <= 24 ){
            averageGrowthTable.setType("M");
            averageGrowthTable.setTime(Long.parseLong(months));
        }else{
            averageGrowthTable.setType("Y");
            Integer year = Math.round(Long.parseLong(months)/12);

            averageGrowthTable.setTime(Long.parseLong(year.toString()));
        }
        return this.averageGrowthTableService.select(averageGrowthTable);
    }

//    @RequestMapping(value="/{userId}", method=RequestMethod.GET)
//    @ResponseBody
//    public Object view(@PathVariable("userId") Long userId, User user) {
//        return this.userService.select(userId);
//    }
//
//    @RequestMapping(method=RequestMethod.POST)
//    @ResponseBody
//    public Object add(@RequestBody User user) {
//        return this.userService.insert(user);
//    }
//
//    @RequestMapping(value="/{userId}", method=RequestMethod.PUT)
//    @ResponseBody
//    public Object edit(@PathVariable("userId") Long userId, @RequestBody User user) {
//        return this.userService.update(user);
//    }
//
//    @RequestMapping(value="/{userId}", method=RequestMethod.DELETE)
//    @ResponseBody
//    public Object delete(@PathVariable("userId") Long userId) {
//        return this.userService.delete(userId);
//    }

}