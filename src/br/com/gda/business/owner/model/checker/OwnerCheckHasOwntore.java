package br.com.gda.business.owner.model.checker;

import java.sql.Connection;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class OwnerCheckHasOwntore extends ModelCheckerTemplateSimple_<OwnerInfo> {
	
	public OwnerCheckHasOwntore(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OwnerInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.owntores == null)			
			return super.FAILED;		
		
		if (recordInfo.owntores.isEmpty())			
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.OWNER_STORE_IS_NULL)
			return SystemMessage.OWNER_STORE_IS_NULL;
		
		return SystemMessage.OWNER_STORE_IS_FILLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.OWNER_STORE_IS_FILLED;	
			
		return SystemCode.OWNER_STORE_IS_NULL;
	}
}
