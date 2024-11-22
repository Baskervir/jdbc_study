package org.newsystem.dao;

import java.util.List;

public interface UserManageDao {
    List<UserDTO> findAll(int pageNum, int pageSize);
    List<OneUserDTO> findOne(String firstName, String lastName);
}
