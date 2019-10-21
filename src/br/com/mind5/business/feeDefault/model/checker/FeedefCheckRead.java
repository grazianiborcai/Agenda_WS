package br.com.mind5.business.feeDefault.model.checker;

import java.sql.Connection;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class FeedefCheckRead extends ModelCheckerTemplateSimple_<FeedefInfo> {

	public FeedefCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(FeedefInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codFeeCateg == DefaultValue.character()
			|| recordInfo.codCurr == null )			
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
