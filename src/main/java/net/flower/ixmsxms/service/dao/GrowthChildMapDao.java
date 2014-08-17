package net.flower.ixmsxms.service.dao;

import net.flower.ixmsxms.service.domain.GrowthChildMap;

import java.util.List;

@Master
public interface GrowthChildMapDao {
    public List<GrowthChildMap> selectList(Long growthId);
    public int insert(GrowthChildMap growthChildMap);
    public int delete(GrowthChildMap growthChildMap);
}
