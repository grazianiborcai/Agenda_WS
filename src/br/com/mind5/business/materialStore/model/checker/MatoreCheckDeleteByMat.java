package br.com.mind5.business.materialStore.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatoreCheckDeleteByMat extends ModelCheckerTemplateSimple<MatoreInfo> {

	public MatoreCheckDeleteByMat(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatoreInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0	|| 	
			 recordInfo.codMat		<= 0	||
			 recordInfo.codLanguage	== null	||
			 recordInfo.username	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_STORE_MANDATORY_FIELD_EMPTY;
	}
}
