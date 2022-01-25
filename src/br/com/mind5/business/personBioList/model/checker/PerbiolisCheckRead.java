package br.com.mind5.business.personBioList.model.checker;

import java.sql.Connection;

import br.com.mind5.business.personBioList.info.PerbiolisInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PerbiolisCheckRead extends ModelCheckerTemplateSimple<PerbiolisInfo> {

	public PerbiolisCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PerbiolisInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0	||
			recordInfo.codPerson 	<= 0	||
			recordInfo.codLanguage	== null	||
			recordInfo.username		== null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_BIO_LIST_MANDATORY_FIELD_EMPTY;
	}
}
