package com.construction.action;

import java.util.List;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.construction.dao.UserDao;
import com.construction.model.User;


public class UserController extends MultiActionController {

    private UserDao userDAO;

    public void setUserDAO(UserDao userDAO) {
    	this.userDAO = userDAO;
    }

    public ModelAndView show(HttpServletRequest request,
		HttpServletResponse response, User user) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("user", user);
		return new ModelAndView("userform");
    }

	public ModelAndView add(HttpServletRequest request,
		HttpServletResponse response, User user) throws Exception {
		userDAO.saveUser(user);
		return new ModelAndView("users");
	}

    public ModelAndView view(HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
    	List<User> listUser = userDAO.getListUser();
    	request.setAttribute("listUser", listUser);
	    return new ModelAndView("users");
    }
}
