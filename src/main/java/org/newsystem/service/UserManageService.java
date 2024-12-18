package org.newsystem.service;

import org.newsystem.dao.UserDTO;
import org.newsystem.dao.OneUserDTO;
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

    public List<OneUserInfo> findByOne(String firstName, String lastName) {
        List<OneUserDTO> oneUser = this.dao.findOne(firstName, lastName);
        List<OneUserInfo> info = new ArrayList<>();

        for (OneUserDTO userDTO : oneUser) {
            info.add(userDTO.mapToInfo());
        }

        return info;
    }

    public OneUserInfo addUser(String firstName, String lastName) {
        OneUserDTO addedUser = this.dao.addOne(firstName,lastName);

        return addedUser.mapToInfo();
    }
}