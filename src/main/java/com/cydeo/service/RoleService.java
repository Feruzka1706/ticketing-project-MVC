package com.cydeo.service;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;

import java.util.List;

public interface RoleService extends CrudService<RoleDTO,Long>{

    // CRUD operators - save, findById, deleteRow, getAllRow (findAll())

    //Let's say if I have some other specific logic which is related for RoleService
   // RoleDTO myLogic(RoleDTO user, String str);

}
