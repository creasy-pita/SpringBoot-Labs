package cn.iocoder.springboot.lab17.dynamicdatasource.dataobject.mysql;

import javax.persistence.*;

/**
 * Created by lujq on 11/2/2021.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class MysqlBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "Id")
    private long id;
}
