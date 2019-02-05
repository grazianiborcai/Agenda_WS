package br.com.gda.business.owner.model.checker;

import java.sql.Connection;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class OwnerCheckUpdatePerson extends ModelCheckerTemplateSimple<OwnerInfo> {
	
	public OwnerCheckUpdatePerson() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OwnerInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.personData == null)			
			return super.FAILED;		
		
		if (recordInfo.personData.codOwner  != recordInfo.codOwner	||
			recordInfo.personData.codPerson != recordInfo.codPerson		)			
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {	
		return SystemMessage.PERSON_MISMATCH;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PERSON_MISMATCH;
	}
}
