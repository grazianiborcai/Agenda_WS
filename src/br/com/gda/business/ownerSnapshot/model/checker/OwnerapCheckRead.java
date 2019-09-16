package br.com.gda.business.ownerSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.ownerSnapshot.info.OwnerapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class OwnerapCheckRead extends ModelCheckerTemplateSimpleV2<OwnerapInfo> {

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
