package br.com.mind5.message.emailScheduleCancellation.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.message.emailScheduleCancellation.info.EmulelInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class EmulelCheckSend extends ModelCheckerTemplateSimple<EmulelInfo> {

	public EmulelCheckSend(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmulelInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner	<= 0	||
			 recordInfo.codStore	<= 0	||
			 recordInfo.codCustomer	<= 0	||
			 recordInfo.codMat		<= 0	||
			 recordInfo.codEmployee	<= 0	||
			 recordInfo.date		== null	||
			 recordInfo.beginTime	== null	||
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMAIL_SCHEDU_CANCEL_MANDATORY_FIELD_EMPTY;
	}
}
