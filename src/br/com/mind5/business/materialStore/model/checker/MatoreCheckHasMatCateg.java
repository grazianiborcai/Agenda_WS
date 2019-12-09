package br.com.mind5.business.materialStore.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MatoreCheckHasMatCateg extends ModelCheckerTemplateSimpleV2<MatoreInfo> {

	public MatoreCheckHasMatCateg(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatoreInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.matlisData == null )
			return super.FAILED;
		
		
		if ( recordInfo.matlisData.codMatCateg <= 0 )
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_STORE_MAT_CATEG_IS_NULL;
	}	
}
