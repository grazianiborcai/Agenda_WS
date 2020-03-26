package br.com.mind5.business.feeOwner.model.checker;

import java.sql.Connection;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class FeewnerCheckReadService extends ModelCheckerTemplateSimple<FeewnerInfo> {

	public FeewnerCheckReadService(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FeewnerInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner <= 0
			|| recordInfo.codCurr  == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_FEE_MANDATORY_FIELD_EMPTY;
	}
}
