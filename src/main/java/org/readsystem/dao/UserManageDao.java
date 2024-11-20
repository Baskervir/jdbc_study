package org.readsystem.dao;

import java.util.List;

public interface UserManageDao {
    List<UserDTO> find(int actorId);
}
