package cn.iocoder.springboot.lab17.dynamicdatasource.repository.mysql;

import cn.iocoder.springboot.lab17.dynamicdatasource.dataobject.mysql.MysqlUser;
import org.springframework.data.repository.CrudRepository;

public interface MysqlUserRepository extends CrudRepository<MysqlUser, Integer> {

}
