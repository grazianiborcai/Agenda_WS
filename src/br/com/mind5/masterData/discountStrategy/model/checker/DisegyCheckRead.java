package br.com.mind5.masterData.discountStrategy.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.discountStrategy.info.DisegyInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class DisegyCheckRead extends ModelCheckerTemplateSimple<DisegyInfo> {
	
	public DisegyCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(DisegyInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codDiscountStrategy <= 0 	||
			 recordInfo.codLanguage 		== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.DISCOUNT_STRATEGY_MANDATORY_FIELD_EMPTY;
	}
}
