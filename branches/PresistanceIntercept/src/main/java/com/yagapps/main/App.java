package com.yagapps.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.yagapps.domain.Users;

public class App {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = null;

		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HibernateTemplate htemplate = context.getBean("hibernateTemplate",
				HibernateTemplate.class);

		Users user = new Users();

		user.setUserName("AndhraPradesh");

		user.setPassword("Ramesh");

		user.setEnabled(true);

		user.setAccountNonExpired(false);

		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);

		htemplate.save(user);

	}

}
