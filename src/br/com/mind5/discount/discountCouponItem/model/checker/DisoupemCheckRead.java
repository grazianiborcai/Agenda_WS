package br.com.mind5.discount.discountCouponItem.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class DisoupemCheckRead extends ModelCheckerTemplateSimple<DisoupemInfo> {

	public DisoupemCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(DisoupemInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 		<= 0 	||
			recordInfo.codCouponItem 	<= 0 	||
			recordInfo.username 		== null ||
			recordInfo.codLanguage 		== null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.DISCOUNT_COUPON_MANDATORY_FIELD_EMPTY;
	}
}
