package br.com.mind5.masterData.areaPhone.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.areaPhone.info.AreaneInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class AreaneCheckRead extends ModelCheckerTemplateSimple<AreaneInfo> {
	
	public AreaneCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(AreaneInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codCountryPhone <= 0 	||
			 recordInfo.codArea 		== null ||
			 recordInfo.codLanguage 	== null 	)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.AREA_PHONE_MANDATORY_FIELD_EMPTY;
	}
}
