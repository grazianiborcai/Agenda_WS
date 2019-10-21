package br.com.mind5.business.employee.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class EmpCheckWritePhone extends ModelCheckerTemplateSimple_<EmpInfo> {

	public EmpCheckWritePhone() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmpInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.phones == null)
			return SUCCESS;
		
		
		if (recordInfo.phones.isEmpty())
			return SUCCESS;
		
		
		for (PhoneInfo eachPhone : recordInfo.phones) {
			if (checkPhone(eachPhone) == FAILED)
				return FAILED;
		}
		
		
		return SUCCESS;
	}
	
	
	
	private boolean checkPhone(PhoneInfo phone) {
		if (phone.codPhone <= 0)
			return SUCCESS;
		
		return FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PHONE_COD_IS_FILLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PHONE_COD_IS_FILLED;
	}
}
