package br.com.mind5.business.orderSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class OrdarchCheckRead extends ModelCheckerTemplateSimple_<OrdarchInfo> {

	public OrdarchCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrdarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.ORDER_SEARCH_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.ORDER_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
