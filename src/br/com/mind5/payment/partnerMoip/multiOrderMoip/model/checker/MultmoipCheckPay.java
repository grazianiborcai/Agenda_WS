package br.com.mind5.payment.partnerMoip.multiOrderMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class MultmoipCheckPay extends ModelCheckerTemplateSimple_<MultmoipInfo> {

	public MultmoipCheckPay() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MultmoipInfo recordInfo, Connection conn, String schemaName) {			
		if ( recordInfo.codOwner 		<= 0	||		
			 recordInfo.codPayOrder 	<= 0	||	
			 recordInfo.txtFeeCateg 	== null	||
			 recordInfo.codLanguage 	== null	||
			 recordInfo.username 		== null	||
		     recordInfo.payordems		== null	||
		     recordInfo.cusparData		== null	||
		     recordInfo.sysparData		== null		)	
			
			return super.FAILED;
		
		
		if (recordInfo.payordems.isEmpty())
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MULT_MOIP_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MULT_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
