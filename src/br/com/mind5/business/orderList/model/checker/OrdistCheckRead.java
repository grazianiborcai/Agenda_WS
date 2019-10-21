package br.com.mind5.business.orderList.model.checker;

import java.sql.Connection;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class OrdistCheckRead extends ModelCheckerTemplateSimple_<OrdistInfo> {

	public OrdistCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrdistInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		if ( recordInfo.codOrder 		<= 0 	&& 
			 recordInfo.codCustomer		<= 0	&&
			 recordInfo.codOrderStatus	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.ORDER_LIST_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.ORDER_LIST_MANDATORY_FIELD_EMPTY;
	}
}
