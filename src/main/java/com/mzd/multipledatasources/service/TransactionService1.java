package com.mzd.multipledatasources.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mzd.multipledatasources.bean.TestBean;
import com.mzd.multipledatasources.dao.TransactionDao1;

//自动注册到spring容器，不需要在applicationContext.xml中定位bean
@Service
public class TransactionService1 {
	@Autowired
	private TransactionDao1 ts1;

	/*****
	 * PROPAGATION_REQUIRED ： 支持当前事务，如果当前没有事务，就新建一个事务，这也是最常见的
	 * PROPAGATION_SUPPORTS ： 支持当前事务，如果当前没有事务，就以非事务的方式执行
	 * PROPAGATION_MANDATORY： 支持当前事务，如果当前没有事务，就抛异常
	 * PROPAGATION_REQUIRES_NEW：新建事务，如果当前事务存在，就把当前事务挂起
	 * PROPAGATION_NOT_SUPPORTED：以非事务的方式执行，如果存在当前事务，就把当前事务挂起
	 * PROPAGATION_NEVER： 以非事务的方式执行，如果当前存在事务，就抛异常
	 * PROPAGATION_NESTED：如果存在当前事务，则在嵌套事务内执行，如果当前没有事务，则新建一个事务
	 */

	@Transactional
	public void test01_saveTestBean(TestBean t) {
		ts1.save(t);
	}

}
