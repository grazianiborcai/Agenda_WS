package br.com.mind5.business.employee.model.checker;

import java.sql.Connection;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class EmpCheckWriteAddress extends ModelCheckerTemplateSimple_<EmpInfo> {

	public EmpCheckWriteAddress() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmpInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.addresses == null)
			return SUCCESS;
		
		
		if (recordInfo.addresses.isEmpty())
			return SUCCESS;
		
		
		for (AddressInfo eachAddress : recordInfo.addresses) {
			if (checkAddress(eachAddress) == FAILED)
				return FAILED;
		}
		
		
		return SUCCESS;
	}
	
	
	
	private boolean checkAddress(AddressInfo address) {
		if (address.codAddress <= 0)
			return SUCCESS;
		
		return FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.ADDRESS_COD_IS_FILLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.ADDRESS_COD_IS_FILLED;
	}
}
