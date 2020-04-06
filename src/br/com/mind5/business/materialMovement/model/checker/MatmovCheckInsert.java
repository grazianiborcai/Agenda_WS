package br.com.mind5.business.materialMovement.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MatmovCheckInsert extends ModelCheckerTemplateSimpleV2<MatmovInfo> {

	public MatmovCheckInsert(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatmovInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.username 		== null 					||
			 recordInfo.codLanguage 	== null						||
			 recordInfo.codOwner		<= 0						||
			 recordInfo.codStore		<= 0						||
			 recordInfo.codMat			<= 0						||
			 recordInfo.codMatmovType	== DefaultValue.character() ||
			 recordInfo.quantity		<= 0	)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_MOV_MANDATORY_FIELD_EMPTY;
	}
}
