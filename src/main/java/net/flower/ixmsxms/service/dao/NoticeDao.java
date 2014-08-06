package net.flower.ixmsxms.service.dao;

import net.flower.ixmsxms.service.domain.Notice;
import net.flower.ixmsxms.service.domain.User;

import java.util.List;

@Master
public interface NoticeDao {
    public List<Notice> selectList(Notice notice);
    public int selectListCount(Notice notice);
}