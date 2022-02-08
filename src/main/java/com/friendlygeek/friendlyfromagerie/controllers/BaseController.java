package com.friendlygeek.friendlyfromagerie.controllers;

import javax.servlet.http.HttpSession;

public class BaseController {
	
	protected boolean isLoggedIn(HttpSession session) {
		return session.getAttribute("user") != null;
	}
}
