package org.newsystem.service;

import org.newsystem.dao.UserDTO;
import org.newsystem.dao.UserManageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserManageService {
    private final UserManageDao dao;

    @Autowired
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
