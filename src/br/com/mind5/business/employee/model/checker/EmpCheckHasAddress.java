package br.com.mind5.business.employee.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class EmpCheckHasAddress extends ModelCheckerTemplateSimple_<EmpInfo> {
	
	public EmpCheckHasAddress(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.addresses == null)			
			return super.FAILED;		
		
		if (recordInfo.addresses.isEmpty())			
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.ADDRESS_IS_NULL)
			return SystemMessage.ADDRESS_IS_NULL;
		
		return SystemMessage.ADDRESS_IS_FILLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.ADDRESS_IS_FILLED;	
			
		return SystemCode.ADDRESS_IS_NULL;
	}
}
