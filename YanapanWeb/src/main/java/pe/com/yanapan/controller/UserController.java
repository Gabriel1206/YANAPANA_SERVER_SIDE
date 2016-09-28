package pe.com.yanapan.controller;

import java.util.ArrayList;
import java.util.List;






import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import pe.com.yanapan.beans.GenericResponseBean;
import pe.com.yanapan.beans.RequiredFields;
import pe.com.yanapan.beans.ResponseListBean;
import pe.com.yanapan.beans.Retorno;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Beneficiary;
import pe.com.yanapan.model.Imei;
import pe.com.yanapan.model.User;
import pe.com.yanapan.service.UserService;
import pe.com.yanapan.service.UsersService;
import pe.com.yanapan.utils.GlobalMessages;
import pe.com.yanapan.utils.OperadoresUtil;
//import com.google.gson.Gson;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private UsersService usersService;
	
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

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		return "logout";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String users(HttpServletRequest request) {
		return "users";
	}
	
	@RequestMapping(value = "/user-validate.json", method = RequestMethod.POST, produces="application/json")
	public String userValidate(
			@RequestParam(value = "nickUser", defaultValue = "") String nickUser,
			@RequestParam(value = "password", defaultValue = "") String password) throws BusinessException {
			
			GenericResponseBean<User> responseBean = new GenericResponseBean<User>();
			responseBean.setObjeto(service.findByUserAndPassword(nickUser, password));
			
			if (nickUser.equals(responseBean.getObjeto().getNickUser()) && (password.equals(responseBean.getObjeto().getPassword())) ){
				return "inicio";
			} else {
				return "login";
			}
			
	}
	
	@RequestMapping(value = "/users-all.json", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody ResponseListBean<User> reportUsers(
			@RequestParam(value = "page", defaultValue = "1") Integer pagina, 
			@RequestParam(value = "row", defaultValue = "20") Integer registros,
			@RequestParam(value = "idUser", defaultValue = "0") Integer idUser) {
			
			ResponseListBean<User> responseBean = new ResponseListBean<User>();
			
			List<User> reportUsers = usersService.listAllUser();
			
			Integer totalUser = reportUsers.size();
			responseBean.setPage(pagina);
			responseBean.setRecords(totalUser);
			
			responseBean.setTotal(OperadoresUtil.obtenerCociente(totalUser, registros));
			responseBean.setRows(reportUsers);
			
			return responseBean;
			
	}
	
	
	@RequestMapping(value = "/save-user.json", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody String saveUser(User user){
		Gson gson = new Gson();
		List<RequiredFields> camposObligatorios = new ArrayList<RequiredFields>();
				
		int codigo = 0;
		String mensaje = "";
		String listaObligatorios = gson.toJson(camposObligatorios);
		
		if(camposObligatorios.size() > 0){
			
			codigo = 0;
			
		}else{
			
			Retorno retorno = usersService.saveUser(user);
			codigo = retorno.getCodigoUsuario();
			mensaje = retorno.getMensajeRetorno();
		}
	 
		String resultado = "{\"idUsuario\":" + codigo + ",\"camposObligatorios\":" + listaObligatorios + ",\"mensaje\":\"" + mensaje + "\"}";
		
		return resultado;
	}
	
}
