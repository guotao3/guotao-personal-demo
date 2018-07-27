package cc.dao.impl;

import cc.dao.IUserDao;
import cc.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDao<UserEntity> implements IUserDao {

}
