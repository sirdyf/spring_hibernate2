package ru.naumen.demo.services;



import org.springframework.transaction.annotation.Propagation;

import org.springframework.transaction.annotation.Transactional;

import ru.naumen.demo.dao.IEntityDao;


import ru.naumen.demo.entity.MyEntity;







@Transactional(readOnly = true)

public class MyEntityService implements IMyEntityService

{

    private IEntityDao dao;



    public void setDao(IEntityDao dao)

    {

        this.dao = dao;

    }



    @Override

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)

    public void saveEntity(MyEntity entity)

    {

        dao.save(entity);

    }

}