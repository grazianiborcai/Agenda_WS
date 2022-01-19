package br.com.mind5.masterData.petType.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.petType.info.PetypeInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PetypeCheckRead extends ModelCheckerTemplateSimple<PetypeInfo> {

	public PetypeCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PetypeInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codPetype 		<= 0 	||
			 recordInfo.codLanguage == null 	)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PET_TYPE_MANDATORY_FIELD_EMPTY;
	}
}
