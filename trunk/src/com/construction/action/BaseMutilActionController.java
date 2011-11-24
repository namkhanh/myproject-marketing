package com.construction.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of <strong>BaseMutilActionController</strong> that contains
 * convenience methods for subclasses.  For example, getting the current
 * user and saving messages/errors. This class is intended to
 * be a base class for all MutilAction controllers.
 *
 * @author <a href="mailto:trunghien84@gmail.com">Huynh Trung Hien</a>
 */
public class BaseMutilActionController extends MultiActionController implements ServletContextAware {
	protected final transient Log log = LogFactory.getLog(getClass());
	protected final String MESSAGES_KEY = "successMessages";
	protected final String ERRORS_KEY = "errors";

    /**
     * Convenient method for getting a i18n key's value with a single
     * string argument.
     */
	public String getText(String msgKey, String arg) {
		return getText(msgKey, new Object[] { arg });
	}

	/**
	 * Convenience method for getting a i18n key's value with arguments.
	 */
	public String getText(String msgKey, Object[] args) {
		return getMessageSourceAccessor().getMessage(msgKey, args);
	}

	@SuppressWarnings("unchecked")
	public void saveMessage(HttpServletRequest request, String msg) {
		List<String> messages = (List<String>) request.getSession().getAttribute(MESSAGES_KEY);

		if (messages == null) {
			messages = new ArrayList<String>();
		}

		messages.add(msg);
		request.getSession().setAttribute(MESSAGES_KEY, messages);
	}

	@SuppressWarnings("unchecked")
	public void saveError(HttpServletRequest request, String msg) {
		List<String> errors = (List<String>) request.getSession().getAttribute(ERRORS_KEY);

		if (errors == null) {
			errors = new ArrayList<String>();
		}

		errors.add(msg);
		request.getSession().setAttribute(ERRORS_KEY, errors);
	}

	public final String getUrlString(final String t, final String p, final String s, final String o) {
		return "t=" + t + "&p=" + p + "&s=" + s + "&o=" + o;
	}

	public final String getUrlString(final String t, final String p, final String s,
			final String o, final String ex1, final String ex2) {
		return "t=" + t + "&p=" + p + "&s=" + s + "&o=" + o + "&ex1=" + ex1 + "&ex2=" + ex2;
	}

}