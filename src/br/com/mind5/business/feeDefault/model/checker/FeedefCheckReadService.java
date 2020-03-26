package br.com.mind5.business.feeDefault.model.checker;

import java.sql.Connection;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class FeedefCheckReadService extends ModelCheckerTemplateSimple<FeedefInfo> {

	public FeedefCheckReadService(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FeedefInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codCurr == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FEE_DEFAULT_MANDATORY_FIELD_EMPTY;
	}
}
