package br.com.gda.business.phoneSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class PhonapCheckWrite extends ModelCheckerTemplateSimpleV2<PhonapInfo> {

	public PhonapCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PhonapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 || 
			 recordInfo.codPhone 	<= 0	)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_SNAPSHOT_MANDATORY_FIELD_EMPTY;
	}
}
