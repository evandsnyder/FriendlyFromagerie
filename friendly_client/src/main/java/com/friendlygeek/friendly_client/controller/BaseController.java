package com.friendlygeek.friendly_client.controller;

import javax.servlet.http.HttpSession;

public class BaseController {
    protected boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("user") != null;
    }

}
