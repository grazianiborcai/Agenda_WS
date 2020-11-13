package br.com.mind5.business.materialStore.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialCategory.info.Mateg;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatoreCheckIsService extends ModelCheckerTemplateSimple<MatoreInfo> {

	public MatoreCheckIsService(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatoreInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.matlisData == null )	
			return super.FAILED;
		
		
		if ( recordInfo.matlisData.codMatCateg == Mateg.SERVICE.getCodMatCateg() )	
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_STORE_IS_SERVICE;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_STORE_IS_NOT_SERVICE;
	}
}
