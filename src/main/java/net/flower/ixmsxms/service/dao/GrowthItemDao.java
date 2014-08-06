package net.flower.ixmsxms.service.dao;

import net.flower.ixmsxms.service.domain.GrowthItem;

import java.util.List;

@Master
public interface GrowthItemDao {
    public List<GrowthItem> selectList(Long growthId);
    public int insert(GrowthItem growthItems);
    public int delete(GrowthItem growthItems);
}
