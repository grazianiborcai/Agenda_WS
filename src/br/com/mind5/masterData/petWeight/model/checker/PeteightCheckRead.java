package br.com.mind5.masterData.petWeight.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.petWeight.info.PeteightInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PeteightCheckRead extends ModelCheckerTemplateSimple<PeteightInfo> {

	public PeteightCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PeteightInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codPeteight <= 0 	||
			 recordInfo.codLanguage == null 	)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PET_WEIGHT_MANDATORY_FIELD_EMPTY;
	}
}
