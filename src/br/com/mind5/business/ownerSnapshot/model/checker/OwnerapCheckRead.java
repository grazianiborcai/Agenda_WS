package br.com.mind5.business.ownerSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class OwnerapCheckRead extends ModelCheckerTemplateSimple<OwnerapInfo> {

	public OwnerapCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OwnerapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0		||
			 recordInfo.codSnapshot <= 0		||	
			 recordInfo.codLanguage == null)
			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.OWNER_SNAP_MANDATORY_FIELD_EMPTY;
	}	
}
