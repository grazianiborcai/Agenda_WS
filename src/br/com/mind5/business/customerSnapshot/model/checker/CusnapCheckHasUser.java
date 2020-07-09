package br.com.mind5.business.customerSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class CusnapCheckHasUser extends ModelCheckerTemplateSimpleV2<CusnapInfo> {

	public CusnapCheckHasUser(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusnapInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codUser 		<= 0 	||
			recordInfo.codLanguage 	== null	||
			recordInfo.username 	== null		)			
			
			return super.FAILED;		
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CUS_SNAPSHOT_MANDATORY_FIELD_EMPTY;
	}
}
