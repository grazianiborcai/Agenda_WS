package br.com.mind5.masterData.gender.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.gender.info.GenderInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class GenderCheckRead extends ModelCheckerTemplateSimple<GenderInfo> {

	public GenderCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(GenderInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codGender   <= 0 	||
			 recordInfo.codLanguage == null 	)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.GENDER_MANDATORY_FIELD_EMPTY;
	}
}
