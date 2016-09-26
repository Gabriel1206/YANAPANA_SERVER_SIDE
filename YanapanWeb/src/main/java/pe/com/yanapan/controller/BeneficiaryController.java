package pe.com.yanapan.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.Messages;

import pe.com.yanapan.beans.GenericResponseBean;
import pe.com.yanapan.beans.ResponseListBean;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Beneficiary;
import pe.com.yanapan.model.Imei;
import pe.com.yanapan.model.User;
import pe.com.yanapan.service.BeneficiaryService;
import pe.com.yanapan.service.ImeiService;
import pe.com.yanapan.utils.GlobalMessages;

@Controller
public class BeneficiaryController {

	@Autowired
	private BeneficiaryService beneficiaryService;
	
	@RequestMapping(value = "/beneficiary", method = RequestMethod.GET)
	public String iniBenefiaciry(HttpServletRequest request) {
		return "beneficiary";
	}
	
	
	@RequestMapping(value = "/beneficiary-all.json", method = RequestMethod.POST, produces="application/json")
	public GenericResponseBean<Beneficiary> listAllBeneficiary(
			@RequestParam(value = "address", defaultValue = "") String address,
			@RequestParam(value = "birthDate", defaultValue = "") Date birthDate,
			@RequestParam(value = "descKnowledge", defaultValue = "") String descKnowledge,
			@RequestParam(value = "firstName", defaultValue = "") String firstName,
			@RequestParam(value = "flagDisabled", defaultValue = "") char flagDisabled,
			@RequestParam(value = "flagKnowledge", defaultValue = "") char flagKnowledge,
			@RequestParam(value = "idBeneficiary", defaultValue = "") int idBeneficiary,
			@RequestParam(value = "idUbigeo", defaultValue = "") int idUbigeo,
			@RequestParam(value = "lastName", defaultValue = "") String lastName,
			@RequestParam(value = "typeBeneficiary", defaultValue = "") int typeBeneficiary) throws BusinessException {
			
			GenericResponseBean<Beneficiary> responseBean = new GenericResponseBean<Beneficiary>();
			responseBean.setObjeto((Beneficiary) beneficiaryService.listAllBeneficiary());
			
			return responseBean;
			
	}
}
