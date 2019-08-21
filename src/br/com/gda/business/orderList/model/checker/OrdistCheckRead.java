package br.com.gda.business.orderList.model.checker;

import java.sql.Connection;

import br.com.gda.business.orderList.info.OrdistInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class OrdistCheckRead extends ModelCheckerTemplateSimple<OrdistInfo> {

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
