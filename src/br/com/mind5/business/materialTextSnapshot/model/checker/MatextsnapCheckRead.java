package br.com.mind5.business.materialTextSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatextsnapCheckRead extends ModelCheckerTemplateSimple<MatextsnapInfo> {

	public MatextsnapCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatextsnapInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0	||
			recordInfo.codSnapshot 	<= 0	||
			recordInfo.codMat 		<= 0		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_TEXT_SNAPSHOT_MANDATORY_FIELD_EMPTY;
	}
}
