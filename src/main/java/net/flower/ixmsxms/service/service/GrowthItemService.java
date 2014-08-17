package net.flower.ixmsxms.service.service;

import net.flower.ixmsxms.service.dao.GrowthItemDao;
import net.flower.ixmsxms.service.domain.GrowthChildMap;
import net.flower.ixmsxms.service.domain.GrowthItem;
import net.flower.ixmsxms.service.utils.PaginateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Transactional
@Service
public class GrowthItemService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private GrowthItemDao growthItemDao;

    public Map<String, Object> selectListPhotoByUserId(GrowthChildMap growthChildMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", this.growthItemDao.selectListPhotoByUserId(growthChildMap));
        System.out.println("@@@@VIOLET");



        int totalCount = this.growthItemDao.selectListPhotoCountByUserId(growthChildMap);
        System.out.println("@@@@TOT");
        System.out.println(totalCount);
        map.put("totalCount", totalCount);
        map.put("page", PaginateTool.paginate(growthChildMap.getPage(), 10, growthChildMap.getCount(), totalCount));
        return map;
    }


}