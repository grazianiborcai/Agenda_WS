package br.com.mind5.business.feeOwner.model.checker;

import java.sql.Connection;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class FeewnerCheckReadService extends ModelCheckerTemplateSimple_<FeewnerInfo> {

	public FeewnerCheckReadService() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(FeewnerInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner <= 0
			|| recordInfo.codCurr  == null )			
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
