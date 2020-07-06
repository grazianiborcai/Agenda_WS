package br.com.mind5.message.emailScheduleConfirmation.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.message.emailScheduleConfirmation.info.EmulonInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class EmulonCheckSend extends ModelCheckerTemplateSimpleV2<EmulonInfo> {

	public EmulonCheckSend(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmulonInfo recordInfo, Connection conn, String schemaName) {	
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
		return SystemCode.EMAIL_SCHEDU_CONFIRM_MANDATORY_FIELD_EMPTY;
	}
}