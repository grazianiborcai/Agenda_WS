package br.com.mind5.masterData.paymentStatusSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.paymentStatusSearch.info.PaymenusarchInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PaymenusarchCheckRead extends ModelCheckerTemplateSimple<PaymenusarchInfo> {
	
	public PaymenusarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PaymenusarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAYMENT_STATUS_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
