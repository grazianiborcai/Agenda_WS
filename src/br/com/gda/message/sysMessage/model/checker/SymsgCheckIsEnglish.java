package br.com.gda.message.sysMessage.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.common.Langu;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.message.sysMessage.info.SymsgInfo;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class SymsgCheckIsEnglish extends ModelCheckerTemplateSimple_<SymsgInfo> {

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
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.SYS_MESSAGE_IS_ENGLISH)
			return SystemMessage.SYS_MESSAGE_IS_ENGLISH;
		
		return SystemMessage.SYS_MESSAGE_IS_NOT_ENGLISH;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == SUCCESS)
			return SystemCode.SYS_MESSAGE_IS_ENGLISH;	
			
		return SystemCode.SYS_MESSAGE_IS_NOT_ENGLISH;
	}
}
