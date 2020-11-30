package co.rachel.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberCommand {
	public String action(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException;
}
