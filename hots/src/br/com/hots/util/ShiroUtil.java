package br.com.hots.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroUtil {

	Subject currentUser = SecurityUtils.getSubject();

	@Produces
	@RequestScoped
	public Subject getCurrentUser() {
		return currentUser;
	}

}