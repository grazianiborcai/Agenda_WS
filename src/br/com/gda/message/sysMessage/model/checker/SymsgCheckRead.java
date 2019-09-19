package br.com.gda.message.sysMessage.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.message.sysMessage.info.SymsgInfo;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class SymsgCheckRead extends ModelCheckerTemplateSimple_<SymsgInfo> {

	public SymsgCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SymsgInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage == null	||
			 recordInfo.codMsg		<= 0		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.SYS_MESSAGE_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.SYS_MESSAGE_MANDATORY_FIELD_EMPTY;
	}
}
