package br.com.mind5.message.sysMessage.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.Langu;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class SymsgCheckRead extends ModelCheckerTemplateSimpleV2<SymsgInfo> {

	public SymsgCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SymsgInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage == null	||
			 recordInfo.codMsg		<= 0		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected SymsgInfo readMsgHook() {
		SymsgInfo result = new SymsgInfo();
		
		result.codLanguage = Langu.ENGLISH.getCod();		
		result.codMsg = SystemCode.SYS_MESSAGE_NOT_FOUND;
		result.txtMsg = SystemMessage.SYS_MESSAGE_NOT_FOUND;
		
		return result;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_MESSAGE_MANDATORY_FIELD_EMPTY;
	}
}
