package net.flower.ixmsxms.service.dao;

import net.flower.ixmsxms.service.domain.AverageGrowthTable;

@Master
public interface AverageGrowthTableDao {
    public AverageGrowthTable select(AverageGrowthTable averageGrowthTable);
}