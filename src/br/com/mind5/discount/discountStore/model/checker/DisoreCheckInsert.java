package br.com.mind5.discount.discountStore.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class DisoreCheckInsert extends ModelCheckerTemplateSimple<DisoreInfo> {

	public DisoreCheckInsert(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(DisoreInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 			<= 0 	||	
			 recordInfo.codStore 			<= 0 	||
			 recordInfo.codDiscountStrategy	<= 0	||
			 recordInfo.codLanguage			== null	||	
			 recordInfo.username			== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.DISCOUNT_STORE_MANDATORY_FIELD_EMPTY;
	}
}
