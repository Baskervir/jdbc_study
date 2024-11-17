package org.newsystem.service;

import org.newsystem.dao.UserDTO;
import org.newsystem.dao.UserManageDao;

import java.util.ArrayList;
import java.util.List;

public class UserManageService {
    private final UserManageDao dao;

    public UserManageService(UserManageDao dao) {
        this.dao = dao;
    }

    public List<UserInfo> findByAll(int pageNum, int pageSize) {
        List<UserDTO> all = this.dao.findAll(pageNum, pageSize);
        List<UserInfo> infos = new ArrayList<>();

        for (UserDTO userDTO : all) {
            infos.add(userDTO.mapToInfo());
        }
        return infos;
    }
}
