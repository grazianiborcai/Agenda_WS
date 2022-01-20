package br.com.mind5.business.pet.model.checker;

import java.sql.Connection;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PetCheckInsert extends ModelCheckerTemplateSimple<PetInfo> {

	public PetCheckInsert(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PetInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codPetype	<= 0	||
			 recordInfo.codPeteight	<= 0	||
			 recordInfo.codLanguage	== null	||
			 recordInfo.username	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PET_MANDATORY_FIELD_EMPTY;
	}
}
