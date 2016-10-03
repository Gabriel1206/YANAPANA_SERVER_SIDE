package pe.com.yanapan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.yanapan.beans.ResponseListBean;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Beneficiary;
import pe.com.yanapan.service.BeneficiaryService;
import pe.com.yanapan.utils.OperadoresUtil;

@Controller
public class BeneficiaryController {

	@Autowired
	private BeneficiaryService beneficiaryService;
	
	@RequestMapping(value = "/beneficiary", method = RequestMethod.GET)
	public String iniBenefiaciry(HttpServletRequest request) {
		return "beneficiary";
	}
	
	
	@RequestMapping(value = "/beneficiary-all.json", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody ResponseListBean<Beneficiary> reportBeneficiarys(
			@RequestParam(value = "page", defaultValue = "1") Integer pagina, 
			@RequestParam(value = "row", defaultValue = "20") Integer registros,
			@RequestParam(value = "idBeneficiary", defaultValue = "0") Integer idBeneficiary) throws BusinessException {
			
			ResponseListBean<Beneficiary> responseBean = new ResponseListBean<Beneficiary>();
			
			List<Beneficiary> reportBeneficiary = beneficiaryService.listAll();
			
			Integer totalBeneficiary = reportBeneficiary.size();
			responseBean.setPage(pagina);
			responseBean.setRecords(totalBeneficiary);
			
			responseBean.setTotal(OperadoresUtil.obtenerCociente(totalBeneficiary, registros));
			responseBean.setRows(reportBeneficiary);
			
			return responseBean;
			
	}
}
