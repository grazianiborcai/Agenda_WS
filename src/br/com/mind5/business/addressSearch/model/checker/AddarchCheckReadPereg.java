package br.com.mind5.business.addressSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class AddarchCheckReadPereg extends ModelCheckerTemplateSimple<AddarchInfo> {

	public AddarchCheckReadPereg(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(AddarchInfo recordInfo, Connection conn, String schemaName) {	
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
