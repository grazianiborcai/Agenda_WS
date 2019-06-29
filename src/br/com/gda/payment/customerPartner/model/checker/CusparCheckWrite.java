package br.com.gda.payment.customerPartner.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.customerPartner.info.CusparInfo;

public final class CusparCheckWrite extends ModelCheckerTemplateSimple<CusparInfo> {

	public CusparCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CusparInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 			<= 0 	|| 
			 recordInfo.codPayCustomer 		<= 0 	||			 
			 recordInfo.codAddress 			<= 0 	||
			 recordInfo.codAddressSnapshot 	<= 0 	||
			 recordInfo.codPhone 			<= 0 	||
			 recordInfo.codPhoneSnapshot 	<= 0 	|| 
			 recordInfo.username			== null	||
			 recordInfo.codLanguage			== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_CUS_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_CUS_MANDATORY_FIELD_EMPTY;
	}
}
