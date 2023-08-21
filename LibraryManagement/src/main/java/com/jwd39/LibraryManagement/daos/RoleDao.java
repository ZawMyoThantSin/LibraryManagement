package com.jwd39.LibraryManagement.daos;

import com.jwd39.LibraryManagement.models.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleDao {

    int save(Role role);

    List<Role> getAll();

    int update(Role role);

    Role getById(int id);

    int delete(int id);


}
