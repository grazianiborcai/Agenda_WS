package br.com.mind5.message.emailWelcome.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class EmacomeCheckSend extends ModelCheckerTemplateSimple<EmacomeInfo> {

	public EmacomeCheckSend(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmacomeInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner	<= 0	||
			 recordInfo.codUser		<= 0	||
			 recordInfo.password	== null	||
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMAIL_WELCOME_MANDATORY_FIELD_EMPTY;
	}
}
