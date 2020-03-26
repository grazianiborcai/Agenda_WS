package br.com.mind5.message.sysMessage.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.Langu;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class SymsgCheckNotEnglish extends ModelCheckerTemplateSimple<SymsgInfo> {

	public SymsgCheckNotEnglish(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SymsgInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage == null )			
			return super.SUCCESS;
		
		String english = Langu.ENGLISH.getCod();
		
		if (recordInfo.codLanguage.equals(english))		
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
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SYS_MESSAGE_IS_NOT_ENGLISH;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_MESSAGE_IS_ENGLISH;
	}
}
