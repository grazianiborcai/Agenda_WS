package br.com.mind5.message.emailWelcome.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class EmacomeCheckHasOwnelis extends ModelCheckerTemplateSimpleV2<EmacomeInfo> {

	public EmacomeCheckHasOwnelis(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmacomeInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.ownelisData == null )			
			return super.FAILED;
		
		
		if ( recordInfo.ownelisData.complisData == null )			
			return super.FAILED;
		
		
		if ( recordInfo.ownelisData.complisData.name == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMAIL_WELCOME_MANDATORY_FIELD_EMPTY;
	}
}
