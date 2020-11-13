package br.com.mind5.message.emailBody.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class EmabodyCheckRead extends ModelCheckerTemplateSimple<EmabodyInfo> {

	public EmabodyCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmabodyInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage == null	||
			 recordInfo.codBody		== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMAIL_BODY_MANDATORY_FIELD_EMPTY;
	}
}
