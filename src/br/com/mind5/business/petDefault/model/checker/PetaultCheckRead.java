package br.com.mind5.business.petDefault.model.checker;

import java.sql.Connection;

import br.com.mind5.business.petDefault.info.PetaultInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PetaultCheckRead extends ModelCheckerTemplateSimple<PetaultInfo> {

	public PetaultCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PetaultInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codLanguage	== null	||
			 recordInfo.codUser 	<= 0		)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PET_DEFAULT_MANDATORY_FIELD_EMPTY;
	}
}
