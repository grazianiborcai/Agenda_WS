package br.com.mind5.message.sysMessage.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.Langu;
import br.com.mind5.common.SystemCode;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class SymsgCheckIsEnglish extends ModelCheckerTemplateSimpleV2<SymsgInfo> {

	public SymsgCheckIsEnglish(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SymsgInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage == null )			
			return super.FAILED;
		
		String english = Langu.ENGLISH.getCod();
		
		if (recordInfo.codLanguage.equals(english))		
			return super.SUCCESS;
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SYS_MESSAGE_IS_ENGLISH;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_MESSAGE_IS_NOT_ENGLISH;
	}
}
