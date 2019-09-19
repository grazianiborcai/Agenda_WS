package br.com.gda.business.materialSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class MatsnapCheckWrite extends ModelCheckerTemplateSimple_<MatsnapInfo> {

	public MatsnapCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatsnapInfo recordInfo, Connection conn, String schemaName) {	
		if (    recordInfo.codOwner 	<= 0 
			 || recordInfo.codMat		<= 0	)
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
