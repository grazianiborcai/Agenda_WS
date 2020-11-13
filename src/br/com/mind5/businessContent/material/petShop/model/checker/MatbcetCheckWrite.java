package br.com.mind5.businessContent.material.petShop.model.checker;

import java.sql.Connection;

import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatbcetCheckWrite extends ModelCheckerTemplateSimple<MatbcetInfo> {

	public MatbcetCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatbcetInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||		
			 recordInfo.codStore	<= 0 	||
			 recordInfo.username	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.BC_MAT_PETSHOP_MANDATORY_FIELD_EMPTY;
	}
}
