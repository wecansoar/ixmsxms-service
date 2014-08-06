package net.flower.ixmsxms.service.dao;

import net.flower.ixmsxms.service.domain.AuthenticationDevice;
import net.flower.ixmsxms.service.domain.User;

import java.util.List;

@Master
public interface AuthenticationDeviceDao {
    public AuthenticationDevice selectListByDeviceId(String deviceId);

    public int selectListCount(AuthenticationDevice authenticationDevice);
    public int insert(AuthenticationDevice authenticationDevice);
    public int update(AuthenticationDevice authenticationDevice);
    public int delete(AuthenticationDevice authenticationDevice);
    public int updateByLastlogin(AuthenticationDevice authenticationDevice);
}