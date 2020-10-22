package com.xdaas.admin.test;

import com.xdaas.admin.dal.dataobj.SysUserDO;
import com.xdaas.admin.dal.mapper.SysUserMapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author mathc
 * @since 2020/10/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void testSave() {
        SysUserDO userDO = new SysUserDO();
        userDO.setUsername("bigboss");
        userDO.setPassword("bb1234");
        userDO.setSalt("1234");
        int insert = sysUserMapper.insert(userDO);
        log.debug("debug:{}", insert);
        log.info("info:{}", insert);
        log.warn("warn:{}", insert);
        log.error("error:{}", insert);
    }

}
