package br.com.gda.business.customer.model.checker;

import java.sql.Connection;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class CusCheckHasCus extends ModelCheckerTemplateSimple_<CusInfo> {
	
	public CusCheckHasCus(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codCustomer <= 0)			
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.CUS_DONT_HAS_CUSTOMER)
			return SystemMessage.CUS_DONT_HAS_CUSTOMER;
		
		return SystemMessage.CUS_HAS_CUSTOMER;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.CUS_HAS_CUSTOMER;	
			
		return SystemCode.CUS_DONT_HAS_CUSTOMER;
	}
}
