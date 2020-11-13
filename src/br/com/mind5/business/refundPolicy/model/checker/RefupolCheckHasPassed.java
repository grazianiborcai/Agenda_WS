package br.com.mind5.business.refundPolicy.model.checker;

import java.sql.Connection;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class RefupolCheckHasPassed extends ModelCheckerTemplateSimple<RefupolInfo> {

	public RefupolCheckHasPassed(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(RefupolInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.hasPassed == super.FAILED )	
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_REJECTEC_BY_RULE;
	}
}
