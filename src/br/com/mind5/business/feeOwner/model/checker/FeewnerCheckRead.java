package br.com.mind5.business.feeOwner.model.checker;

import java.sql.Connection;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class FeewnerCheckRead extends ModelCheckerTemplateSimpleV2<FeewnerInfo> {

	public FeewnerCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FeewnerInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner    <= 0
			|| recordInfo.codCurr     == null
			|| recordInfo.codLanguage == null
			|| recordInfo.codFeeCateg == DefaultValue.character() )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_FEE_MANDATORY_FIELD_EMPTY;
	}
}
