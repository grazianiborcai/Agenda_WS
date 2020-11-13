package br.com.mind5.message.emailPasswordChange.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.message.emailPasswordChange.info.EmordeInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class EmordeCheckSend extends ModelCheckerTemplateSimple<EmordeInfo> {

	public EmordeCheckSend(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmordeInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0	||
			 recordInfo.codUser	 	<= 0	||
			 recordInfo.codLanguage	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMAIL_PASSWORD_CHANGE_MANDATORY_FIELD_EMPTY;
	}
}
