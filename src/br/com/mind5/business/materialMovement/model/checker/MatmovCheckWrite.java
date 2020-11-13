package br.com.mind5.business.materialMovement.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatmovCheckWrite extends ModelCheckerTemplateSimple<MatmovInfo> {

	public MatmovCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatmovInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.username 	== null ||
			 recordInfo.codLanguage == null	||
			 recordInfo.codOwner	<= 0	||
			 recordInfo.codMatmov	<= 0		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_MOV_MANDATORY_FIELD_EMPTY;
	}
}
