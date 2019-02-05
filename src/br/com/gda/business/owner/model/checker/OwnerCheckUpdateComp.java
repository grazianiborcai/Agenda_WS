package br.com.gda.business.owner.model.checker;

import java.sql.Connection;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class OwnerCheckUpdateComp extends ModelCheckerTemplateSimple<OwnerInfo> {
	
	public OwnerCheckUpdateComp() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OwnerInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.companyData == null)			
			return super.FAILED;		
		
		if (recordInfo.companyData.codOwner   != recordInfo.codOwner	||
			recordInfo.companyData.codCompany != recordInfo.codCompany		)			
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {	
		return SystemMessage.COMPANY_MISMATCH;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.COMPANY_MISMATCH;
	}
}
