package net.flower.ixmsxms.service.service;

import net.flower.ixmsxms.service.dao.AverageGrowthTableDao;
import net.flower.ixmsxms.service.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class AverageGrowthTableService {
    protected Logger logger = LoggerFactory.getLogger(getClass());


    @Resource
    private AverageGrowthTableDao averageGrowthTableDao;

    public AverageGrowthTable select(AverageGrowthTable averageGrowthTable) {
        averageGrowthTable = this.averageGrowthTableDao.select(averageGrowthTable);

        return averageGrowthTable;
    }

}