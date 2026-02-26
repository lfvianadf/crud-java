package com.viana.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("*.xhtml")
public class AutorizacaoFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        boolean logado = session.getAttribute("usuarioLogado") != null;
        boolean ehPaginaLogin = req.getRequestURI().endsWith("login.xhtml");

        if (logado || ehPaginaLogin) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(req.getContextPath() + "/login.xhtml");
        }
    }
    public void init(FilterConfig filterConfig) {}
    public void destroy() {}
}