package pe.com.yanapan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.yanapan.beans.GenericResponseBean;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Imei;
import pe.com.yanapan.model.User;
import pe.com.yanapan.service.UserService;
import pe.com.yanapan.utils.GlobalMessages;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(value = "v1/users", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
	public @ResponseBody GenericResponseBean<User> validateAcces(
			String user, String password) throws BusinessException {
		GenericResponseBean<User> responseBean = new GenericResponseBean<User>();
		responseBean.setObjeto(service.findByUserAndPassword(user, password));
		
		return responseBean;		
	}
	
	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String inicio(HttpServletRequest request) {
		return "inicio";
	}

	@RequestMapping(value = "/user-validate.json", method = RequestMethod.POST, produces="application/json")
	public String userValidate(
			@RequestParam(value = "nickUser", defaultValue = "") String nickUser,
			@RequestParam(value = "password", defaultValue = "") String password) throws BusinessException {
			
			GenericResponseBean<User> responseBean = new GenericResponseBean<User>();
			responseBean.setObjeto(service.findByUserAndPassword(nickUser, password));
			
			if (nickUser.equals("jmunoz") ){
				return "inicio";
			} else {
				return "login";
			}
			
	}
}
