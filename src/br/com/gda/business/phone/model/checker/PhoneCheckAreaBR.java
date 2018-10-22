package br.com.gda.business.phone.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.CountryPhone;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class PhoneCheckAreaBR extends ModelCheckerTemplateSimple<PhoneInfo> {

	public PhoneCheckAreaBR(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PhoneInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codCountryPhone == CountryPhone.BR.getCodCountryPhone() )			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.PHONE_COUNTRY_IS_BR)
			return SystemMessage.PHONE_COUNTRY_IS_BR;
		
		return SystemMessage.PHONE_COUNTRY_IS_NOT_BR;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.PHONE_COUNTRY_IS_BR;	
			
		return SystemCode.PHONE_COUNTRY_IS_NOT_BR;
	}
}
