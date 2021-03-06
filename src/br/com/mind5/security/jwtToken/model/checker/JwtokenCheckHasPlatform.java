package br.com.mind5.security.jwtToken.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;

public final class JwtokenCheckHasPlatform extends ModelCheckerTemplateSimple<JwtokenInfo> {

	public JwtokenCheckHasPlatform(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(JwtokenInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codPlatform	== null	)				
			return super.FAILED;	
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.TOKEN_MANDATORY_FIELD_EMPTY;
	}
}
