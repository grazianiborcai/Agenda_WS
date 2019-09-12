package br.com.gda.business.owner.model.checker;

import java.sql.Connection;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class OwnerCheckInsert extends ModelCheckerTemplateSimple<OwnerInfo> {

	public OwnerCheckInsert() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OwnerInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.personData 	== null ||
			 recordInfo.companyData == null ||
			 recordInfo.codLanguage == null 	)
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.OWNER_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.OWNER_MANDATORY_FIELD_EMPTY;
	}
}
