package br.com.hots.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpSession sessaoUsuario = rq.getSession(false);
		String login = null;
		
		if (sessaoUsuario != null) {
			login = (String) sessaoUsuario.getAttribute("login");
		}

		if (sessaoUsuario == null || login == null || login.equals("")) {
			HttpServletResponse rp = (HttpServletResponse) response;
			rp.sendRedirect(rq.getContextPath() + "/login.xhtml");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {

	}

	public void init(FilterConfig config) throws ServletException {

	}

}