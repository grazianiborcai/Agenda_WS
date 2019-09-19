package br.com.gda.payment.countryPartner.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.payment.countryPartner.info.CounparInfo;

public final class CounparCheckRead extends ModelCheckerTemplateSimple_<CounparInfo> {

	public CounparCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CounparInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codCountry == null 	)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
