package br.com.mind5.message.emailProspectStore.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.message.emailProspectStore.info.EmaproreInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class EmaproreCheckSend extends ModelCheckerTemplateSimpleV2<EmaproreInfo> {

	public EmaproreCheckSend(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmaproreInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner		<= 0	||
			 recordInfo.password		== null	||
			 recordInfo.recipientAddr	== null	||
			 recordInfo.codLanguage		== null		)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMAIL_PROSP_STORE_MANDATORY_FIELD_EMPTY;
	}
}
