package cc.dao.impl;

import cc.dao.INewsDao;
import cc.entity.NewsEntity;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDaoImpl extends BaseDao<NewsEntity> implements INewsDao {

}
