package br.com.mind5.business.orderSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class OrdarchCheckRead extends ModelCheckerTemplateSimpleV2<OrdarchInfo> {

	public OrdarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OrdarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		if ( recordInfo.codUser 	<= 0 	&& 
			 recordInfo.codCustomer	<= 0		)
				
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
