package com.vishnu.beans;

import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import com.vishnu.scopes.CustomThreadLocal;

public class ThreadScope implements Scope {
	Map<String,Object> scope = null;
	
	CustomThreadLocal threadLocale = new CustomThreadLocal();
	

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		// TODO Auto-generated method stub
		scope = (Map<String,Object>) threadLocale.get();
		Object obj = scope.get(name);
		if(obj==null)
		{
			//no object exists.
			obj = objectFactory.getObject();
			scope.put(name,obj);
		}
		
		return obj;
	}

	@Override
	public String getConversationId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerDestructionCallback(String arg0, Runnable arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object remove(String name) {
		Object obj = scope.remove(name);
		return obj;
	}

	@Override
	public Object resolveContextualObject(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
