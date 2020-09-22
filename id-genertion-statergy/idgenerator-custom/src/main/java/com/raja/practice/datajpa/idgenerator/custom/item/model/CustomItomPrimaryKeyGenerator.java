package com.raja.practice.datajpa.idgenerator.custom.item.model;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;
import java.util.Random;

public class CustomItomPrimaryKeyGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Random random = new Random();
        random.nextInt(100000);
        return  random.nextInt(100000);
    }
}
