package br.com.gda.business.feeOwner.model.checker;

import java.sql.Connection;

import br.com.gda.business.feeOwner.info.FeewnerInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class FeewnerCheckRead extends ModelCheckerTemplateSimple<FeewnerInfo> {

	public FeewnerCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(FeewnerInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner    <= 0
			|| recordInfo.codCurr     == null
			|| recordInfo.codLanguage == null
			|| recordInfo.codFeeCateg == DefaultValue.character() )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
