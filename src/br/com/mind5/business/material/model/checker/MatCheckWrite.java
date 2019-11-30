package br.com.mind5.business.material.model.checker;

import java.sql.Connection;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MatCheckWrite extends ModelCheckerTemplateSimpleV2<MatInfo> {

	public MatCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.codMat 		<= 0 		
			|| recordInfo.txtMat		== null 	
			|| recordInfo.description 	== null	
			|| recordInfo.codType 		<= 0
			|| recordInfo.codMatCateg	<= 0
			|| recordInfo.priceUnit		<= 0
			|| recordInfo.codUnit		== null
			|| recordInfo.codGroup		<= 0
			|| recordInfo.codLanguage	== null
			|| recordInfo.username		== null	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_MANDATORY_FIELD_EMPTY;
	}
}
