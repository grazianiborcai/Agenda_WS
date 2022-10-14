package br.com.mind5.business.phoneSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PhonarchCheckReadPereg extends ModelCheckerTemplateSimple<PhonarchInfo> {

	public PhonarchCheckReadPereg(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PhonarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0 	||
			 recordInfo.codLegalPerson 	<= 0 	||
			 recordInfo.codLanguage		== null		)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
