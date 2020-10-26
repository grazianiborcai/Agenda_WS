package br.com.mind5.businessContent.material.main.model.checker;

import java.sql.Connection;

import br.com.mind5.businessContent.material.main.info.MatbcinInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MatbcinCheckIsPetshop extends ModelCheckerTemplateSimpleV2<MatbcinInfo> {
	private final int BUSINESS_PETSHOP = 3;

	public MatbcinCheckIsPetshop(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatbcinInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codBusiness == BUSINESS_PETSHOP )
			return super.SUCCESS;
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.BC_MAT_MAIN_MANDATORY_FIELD_EMPTY;
	}
}
