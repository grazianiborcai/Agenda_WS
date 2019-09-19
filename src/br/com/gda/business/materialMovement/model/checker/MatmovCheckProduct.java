package br.com.gda.business.materialMovement.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.common.MatCateg;
import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

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
