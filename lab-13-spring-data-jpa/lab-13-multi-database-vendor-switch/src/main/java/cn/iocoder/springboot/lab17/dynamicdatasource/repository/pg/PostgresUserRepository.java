package cn.iocoder.springboot.lab17.dynamicdatasource.repository.pg;

import cn.iocoder.springboot.lab17.dynamicdatasource.dataobject.pg.PgUser;
import org.springframework.data.repository.CrudRepository;

public interface PostgresUserRepository extends CrudRepository<PgUser, Integer> {

}
