package br.com.gda.business.orderSearch.model.checker;

import java.sql.Connection;

import br.com.gda.business.orderSearch.info.OrdarchInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class OrdarchCheckRead extends ModelCheckerTemplateSimple<OrdarchInfo> {

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
