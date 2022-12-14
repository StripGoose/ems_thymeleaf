package com.baizhi.service.Impl;

import com.baizhi.dao.EmpDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Emp;
import com.baizhi.entity.User;
import com.baizhi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
/*控制事务*/
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Emp> findAll() {
        return empDao.findAll();
    }

    @Override
    public void save(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empDao.save(emp);
    }

    @Override
    public void delete(String id) {
        empDao.delete(id);
    }

    @Override
    public Emp find(String id) {
        return empDao.find(id);
    }

    @Override
    public void update(Emp emp) {
        empDao.update(emp);
    }
}
