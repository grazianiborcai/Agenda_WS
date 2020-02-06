package br.com.mind5.business.orderListAuth.model.checker;

import java.sql.Connection;

import br.com.mind5.business.orderListAuth.info.OrdistauInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class OrdistauCheckRead extends ModelCheckerTemplateSimpleV2<OrdistauInfo> {

	public OrdistauCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OrdistauInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		if ( recordInfo.codOrder 			<= 0 	&& 
			 recordInfo.postingYear			<= 0	&&
			 recordInfo.postingYearMonth	<= 0		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_LIST_AUTH_MANDATORY_FIELD_EMPTY;
	}
}
