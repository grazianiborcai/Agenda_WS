package br.com.mind5.business.personBioSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PerbionapCheckRead extends ModelCheckerTemplateSimple<PerbionapInfo> {

	public PerbionapCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PerbionapInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0	||
			recordInfo.codSnapshot 	<= 0	||
			recordInfo.codLanguage	== null	||
			recordInfo.username		== null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_BIO_SNAP_MANDATORY_FIELD_EMPTY;
	}
}
