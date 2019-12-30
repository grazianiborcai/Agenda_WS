package br.com.mind5.business.companySnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class CompnapCheckRead extends ModelCheckerTemplateSimpleV2<CompnapInfo> {

	public CompnapCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CompnapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner  	<= 0 	||
			 recordInfo.codSnapshot <= 0		)	
			
			return super.FAILED;		
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COMPANY_SNAP_MANDATORY_FIELD_EMPTY;
	}
}
