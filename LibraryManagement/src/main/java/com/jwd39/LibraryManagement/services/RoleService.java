package com.jwd39.LibraryManagement.services;

import com.jwd39.LibraryManagement.daos.RoleDao;
import com.jwd39.LibraryManagement.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleDao roleDao;
    @Autowired
    public RoleService(RoleDao roleDao){
        this.roleDao=roleDao;
    }

    public int save(Role role){
        return roleDao.save(role);
    }

    public List<Role> getAll(){
        return roleDao.getAll();
    }

    public int update(Role role){
        return roleDao.update(role);
    }

    public Role getById(int id){
        return roleDao.getById(id);
    }

    public int delete(int id){
        return roleDao.delete(id);
    }

}




