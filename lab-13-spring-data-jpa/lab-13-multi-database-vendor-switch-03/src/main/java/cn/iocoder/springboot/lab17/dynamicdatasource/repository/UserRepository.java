package cn.iocoder.springboot.lab17.dynamicdatasource.repository;

import cn.iocoder.springboot.lab17.dynamicdatasource.dataobject.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
