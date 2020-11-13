package br.com.mind5.message.emailWelcome.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class EmacomeCheckHasPersolis extends ModelCheckerTemplateSimple<EmacomeInfo> {

	public EmacomeCheckHasPersolis(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmacomeInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.persolisData == null )
			
			return super.FAILED;
		
		
		if ( recordInfo.persolisData.name  == null ||
			 recordInfo.persolisData.email == null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMAIL_WELCOME_MANDATORY_FIELD_EMPTY;
	}
}
