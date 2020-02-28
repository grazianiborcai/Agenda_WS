package br.com.mind5.payment.statusPayOrder.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;

public final class PaytusCheckRead extends ModelCheckerTemplateSimpleV2<PaytusInfo> {

	public PaytusCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PaytusInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner    	<= 0	||
			 recordInfo.codPayOrder    	<= 0	||			 
			 recordInfo.codLanguage		== null	||
			 recordInfo.username    	== null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_STATUS_HEADER_MANDATORY_FIELD_EMPTY;
	}
}
