package br.com.mind5.business.ownerList.model.checker;

import java.sql.Connection;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class OwnelisCheckRead extends ModelCheckerTemplateSimple<OwnelisInfo> {

	public OwnelisCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OwnelisInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0	||
			 recordInfo.username 	== null	||
			 recordInfo.codLanguage == null		)
			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.OWNER_LIST_MANDATORY_FIELD_EMPTY;
	}	
}
