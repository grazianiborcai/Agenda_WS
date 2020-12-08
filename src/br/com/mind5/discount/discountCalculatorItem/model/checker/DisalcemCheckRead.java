package br.com.mind5.discount.discountCalculatorItem.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.discount.discountCalculatorItem.info.DisalcemInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class DisalcemCheckRead extends ModelCheckerTemplateSimple<DisalcemInfo> {

	public DisalcemCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(DisalcemInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codUser 		<= 0 	||
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.DISCOUNT_CALC_ITEM_MANDATORY_FIELD_EMPTY;
	}
}
