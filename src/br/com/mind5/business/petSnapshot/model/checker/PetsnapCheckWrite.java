package br.com.mind5.business.petSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PetsnapCheckWrite extends ModelCheckerTemplateSimple<PetsnapInfo> {

	public PetsnapCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PetsnapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codPet		<= 0	||
			 recordInfo.codLanguage	== null	||
			 recordInfo.username	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PET_SNAP_MANDATORY_FIELD_EMPTY;
	}
}
