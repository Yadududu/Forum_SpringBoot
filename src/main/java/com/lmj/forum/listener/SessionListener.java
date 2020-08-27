package com.lmj.forum.listener;

import com.lmj.forum.model.User;
import com.lmj.forum.util.SessionManager;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("监听器");
        if(event.getName().equals("user")) {
            User user = new User();
            user = (User)event.getValue();
            if(SessionManager.SessionMap.containsKey(user.getUsername())) {
                HttpSession httpSession = SessionManager.SessionMap.get(user.getUsername());
                httpSession.removeAttribute("user");
                SessionManager.SessionMap.remove(user.getUsername());
            }
            SessionManager.SessionMap.put(user.getUsername(), event.getSession());
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {

    }
}
