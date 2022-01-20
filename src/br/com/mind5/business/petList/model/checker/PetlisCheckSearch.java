package br.com.mind5.business.petList.model.checker;

import java.sql.Connection;

import br.com.mind5.business.petList.info.PetlisInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PetlisCheckSearch extends ModelCheckerTemplateSimple<PetlisInfo> {

	public PetlisCheckSearch(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PetlisInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner  	<= 0 	||
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)			
			return super.FAILED;	
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PET_LIST_MANDATORY_FIELD_EMPTY;
	}
}
