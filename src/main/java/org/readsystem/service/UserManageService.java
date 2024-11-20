package org.readsystem.service;

import org.readsystem.dao.UserDTO;
import org.readsystem.dao.UserManageDao;

import java.util.ArrayList;
import java.util.List;

public class UserManageService {
    private final UserManageDao dao;

    public UserManageService(UserManageDao dao) {
        this.dao = dao;
    }

    public List<UserInfo> findBySelected(int actorId) {
        List<UserDTO> all = this.dao.find(actorId);
        List<UserInfo> infos = new ArrayList<>();

        for (UserDTO userDTO : all) {
            infos.add(userDTO.mapToInfo());
        }
        return infos;
    }
}
