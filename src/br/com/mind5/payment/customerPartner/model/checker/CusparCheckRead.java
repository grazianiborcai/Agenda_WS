package br.com.mind5.payment.customerPartner.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckRead extends ModelCheckerTemplateSimple_<CusparInfo> {

	public CusparCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CusparInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0 	|| 
			 recordInfo.codPayCustomer	<= 0 	|| 
			 recordInfo.username		== null	||					 
			 recordInfo.codLanguage		== null		)
			
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
