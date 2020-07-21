package br.com.mind5.business.material.model.checker;

import java.sql.Connection;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialCategory.info.Mateg;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MatCheckIsProduct extends ModelCheckerTemplateSimpleV2<MatInfo> {

	public MatCheckIsProduct(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatInfo recordInfo, Connection conn, String schemaName) {	
		
		if ( Mateg.PRODUCT.getCodMatCateg() == recordInfo.codMatCateg )
			return super.SUCCESS;			
			
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_PRODUCT;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_NOT_PRODUCT;
	}
}
