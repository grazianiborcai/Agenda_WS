package br.com.gda.business.materialSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class MatSnapCheckHasSnap extends ModelCheckerTemplateSimple<MatSnapInfo> {

	public MatSnapCheckHasSnap() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatSnapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codSnapshot	<= 0 )				
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MATERIAL_SNAPSHOT_IS_NULL;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MATERIAL_SNAPSHOT_IS_NULL;
	}
}
