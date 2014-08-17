package net.flower.ixmsxms.service.dao;

import net.flower.ixmsxms.service.domain.Growth;
import net.flower.ixmsxms.service.domain.GrowthChildMap;
import net.flower.ixmsxms.service.domain.GrowthItem;

import java.util.List;

@Master
public interface GrowthItemDao {
    public List<GrowthItem> selectList(Long growthId);
    public List<GrowthItem> selectListPhotoByUserId(GrowthChildMap growthChildMap);
    public int selectListPhotoCountByUserId(GrowthChildMap growthChildMap);

    public int insert(GrowthItem growthItems);
    public int delete(GrowthItem growthItems);
}
