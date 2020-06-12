package br.com.mind5.message.email.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class EmailCheckProspectStore extends ModelCheckerTemplateSimpleV2<EmailInfo> {

	public EmailCheckProspectStore(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmailInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.bodyData == null)
			return super.FAILED;
		
		
		if (recordInfo.bodyData.param01 == null ||
			recordInfo.bodyData.param02 == null		)				
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMAIL_MANDATORY_FIELD_EMPTY;
	}
}
