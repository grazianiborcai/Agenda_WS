package br.com.mind5.business.materialMovement.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.MatCateg;
import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class MatmovCheckProduct extends ModelCheckerTemplateSimple_<MatmovInfo> {

	public MatmovCheckProduct() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatmovInfo recordInfo, Connection conn, String schemaName) {	
		if (MatCateg.PRODUCT.getCodMatCateg() == recordInfo.codMatCateg)				
			return super.SUCCESS;		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MAT_MOV_MAT_CATEG_ILLEGAL;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MAT_MOV_MAT_CATEG_ILLEGAL;
	}
}
