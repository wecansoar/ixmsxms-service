package net.flower.ixmsxms.service.dao;

import java.util.List;

import net.flower.ixmsxms.service.domain.User;

@Master
public interface UserDao {
    public User select(User user);
    public User selectByUserInfo(User user);
    public int insert(User user);
    public int update(User user);
    public int delete(Long userId);
    public int updateByLastlogin(User user);
}