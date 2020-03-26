package br.com.mind5.payment.countryPartner.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

public final class CounparCheckDefault extends ModelCheckerTemplateSimple<CounparInfo> {

	public CounparCheckDefault(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CounparInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codCountry == null )
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_COUNTRY_MANDATORY_FIELD_EMPTY;
	}
}
