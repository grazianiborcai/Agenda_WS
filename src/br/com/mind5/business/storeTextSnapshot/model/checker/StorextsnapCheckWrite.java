package br.com.mind5.business.storeTextSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StorextsnapCheckWrite extends ModelCheckerTemplateSimple<StorextsnapInfo> {

	public StorextsnapCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StorextsnapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 || 	
			 recordInfo.codStore	<= 0 ||
			 recordInfo.codSnapshot	<= 0	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_TEXT_SNAPSHOT_MANDATORY_FIELD_EMPTY;
	}
}
