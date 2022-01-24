package br.com.mind5.business.personBio.model.checker;

import java.sql.Connection;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PerbioCheckInsert extends ModelCheckerTemplateSimple<PerbioInfo> {

	public PerbioCheckInsert(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PerbioInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codPerson	<= 0	||
			 recordInfo.txtBio		== null	||
			 recordInfo.codLanguage	== null	||
			 recordInfo.username	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PET_MANDATORY_FIELD_EMPTY;
	}
}
