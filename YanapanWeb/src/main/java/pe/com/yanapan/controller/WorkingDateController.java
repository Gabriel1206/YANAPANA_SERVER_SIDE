package pe.com.yanapan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import pe.com.yanapan.beans.ResponseListBean;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.User;
import pe.com.yanapan.model.WorkingDate;
import pe.com.yanapan.service.WorkingDateService;
import pe.com.yanapan.utils.OperadoresUtil;

@Controller
public class WorkingDateController extends ExceptionHandlingController{

	@Autowired
	private WorkingDateService service;
	
	@RequestMapping(value = "/working", method = RequestMethod.GET)
	public String users(HttpServletRequest request) {
		return "working";
	}
	
	@RequestMapping(value = "/v1/workingdate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody WorkingDate insertarWorkingDate(
			@RequestBody WorkingDate workingDate) throws BusinessException{
		return service.insert(workingDate);		
	}
	
	@RequestMapping(value = "/v1/workingdate", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = "application/json")
	public @ResponseBody List<WorkingDate> listarWorkingDate() throws BusinessException{
		
		return service.listAll();
	}
	
	@RequestMapping(value = "/working-all.json", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody ResponseListBean<WorkingDate> reportUsers(
			@RequestParam(value = "page", defaultValue = "1") Integer pagina, 
			@RequestParam(value = "row", defaultValue = "20") Integer registros,
			@RequestParam(value = "idWorkingDate", defaultValue = "0") Integer idWorkingDate) throws BusinessException {
			
			ResponseListBean<WorkingDate> responseBean = new ResponseListBean<WorkingDate>();
			
			List<WorkingDate> reportWorkingDate = service.listAll();
			
			Integer totalWorkingDate = reportWorkingDate.size();
			responseBean.setPage(pagina);
			responseBean.setRecords(totalWorkingDate);
			
			responseBean.setTotal(OperadoresUtil.obtenerCociente(totalWorkingDate, registros));
			responseBean.setRows(reportWorkingDate);
			
			return responseBean;
			
	}
}
