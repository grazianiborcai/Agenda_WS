package br.com.gda.business.feeDefault.model.checker;

import java.sql.Connection;

import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class FeeDefaultCheckRead extends ModelCheckerTemplateSimple<FeeDefaultInfo> {

	public FeeDefaultCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(FeeDefaultInfo recordInfo, Connection conn, String schemaName) {	
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
