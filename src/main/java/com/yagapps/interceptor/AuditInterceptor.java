package com.yagapps.interceptor;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import com.yagapps.domain.Users;

public class AuditInterceptor extends EmptyInterceptor {
	
	
	private static final long serialVersionUID = 8350864309219516535L;

	@Override
	public boolean onSave(
			Object entity, 
			Serializable id, 
			Object[] state, 
			String[] propertyNames, 
			Type[] types) {
		System.out.println(entity.getClass()+" is being saved "+id);
		changePassword(state,propertyNames);
		return true;
	}

	private void changePassword(Object[] state, String[] propertyNames) {

		for(int i=0 ;i <propertyNames.length;i++)
		{
			if("password".equals(propertyNames[i]))
			{
				state[i] ="NewPassword";
			}
		}
		
	}

}
