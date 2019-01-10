package br.com.gda.business.owner.model.checker;

import java.sql.Connection;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class OwnerCheckHasAddress extends ModelCheckerTemplateSimple<OwnerInfo> {
	
	public OwnerCheckHasAddress(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OwnerInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.addresses == null || recordInfo.addresses.isEmpty())			
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
