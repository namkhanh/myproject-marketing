package com.construction.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import com.construction.dao.UserDao;
import com.construction.model.User;
import com.construction.util.StringUtil;

@SuppressWarnings("deprecation")
public class UserFormController extends SimpleFormController {

	private UserDao userDAO;

    public void setUserDAO(UserDao userDAO) {
    	this.userDAO = userDAO;
    }

	public UserFormController(){
		setCommandClass(User.class);
		setCommandName("user");
	}

	protected ModelAndView onSubmit(Object command) throws Exception {
		User user = (User) command;
		userDAO.saveUser(user);
		return new ModelAndView("userSuccess","user",user);
	}

	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		if (!(isFormSubmission(request))) {
			String idUser = request.getParameter("id");
			User user = null;
			if (!StringUtil.isEmpty(idUser)) {
				try {
					user = userDAO.findById(Long.parseLong(idUser));
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				user = new User();
			}
			return user;
		}
		return super.formBackingObject(request);
	}

	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		boolean isNew = true;
		User user = (User) command;
		if (user.getId() != null && user.getId() > 0) {
			isNew = false;
		}
		try {
			userDAO.saveUser(user);
		} catch (ConstraintViolationException e) {
			if (isNew) {
				user.setId(null);
			}
			e.printStackTrace();
			return showForm(request, response, errors);
		} catch (Exception e) {
			if (isNew) {
				user.setId(null);
			}
			e.printStackTrace();
			return showForm(request, response, errors);
		}
		return new ModelAndView("redirect:viewUsers.html");
	}

	protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors)
			throws Exception {
		return super.showForm(request, response, errors);
	}
}
