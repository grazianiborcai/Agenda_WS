package br.com.gda.business.customer.model.checker;

import java.sql.Connection;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class CusCheckTechField extends ModelCheckerTemplateSimple<CusInfo> {
	
	public CusCheckTechField() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CusInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codCustomer >= 0 )			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CUS_TECH_FIELD_SHOULD_BE_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CUS_TECH_FIELD_SHOULD_BE_EMPTY;
	}
}
