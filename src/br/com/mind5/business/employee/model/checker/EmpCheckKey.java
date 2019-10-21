package br.com.mind5.business.employee.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class EmpCheckKey extends ModelCheckerTemplateSimple_<EmpInfo> {
	private final boolean KEY_NOT_NULL = true;
	private final boolean EMPTY_KEY = false;
	
	public EmpCheckKey(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	>= 0	&& 
			 recordInfo.codEmployee	>= 0	&&
			 recordInfo.codLanguage != null		)			
			return KEY_NOT_NULL;		
		
		return EMPTY_KEY;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		if (makeFailureCodeHook(checkerResult) == SystemCode.KEY_FIELD_NOT_NULL)
			return SystemMessage.KEY_FIELD_NOT_NULL;
		
		return SystemMessage.KEY_FIELD_IS_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == KEY_NOT_NULL)
			return SystemCode.KEY_FIELD_NOT_NULL;				
		
		return SystemCode.KEY_FIELD_IS_EMPTY;
	}
}
