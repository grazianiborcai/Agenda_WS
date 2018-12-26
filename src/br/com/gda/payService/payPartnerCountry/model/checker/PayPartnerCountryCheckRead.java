package br.com.gda.payService.payPartnerCountry.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payService.payPartnerCountry.info.PayPartnerCountryInfo;

public final class PayPartnerCountryCheckRead extends ModelCheckerTemplateSimple<PayPartnerCountryInfo> {

	public PayPartnerCountryCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayPartnerCountryInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codCountry == null 	)			
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
