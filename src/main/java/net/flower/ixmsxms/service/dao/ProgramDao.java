package net.flower.ixmsxms.service.dao;

import net.flower.ixmsxms.service.domain.Notice;
import net.flower.ixmsxms.service.domain.Program;

import java.util.List;

@Master
public interface ProgramDao {
    public Program select();
}