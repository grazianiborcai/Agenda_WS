package br.com.gda.payment.partnerMoip.multiOrderMoip.model.checker;

import java.sql.Connection;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class MultmoipCheckPay extends ModelCheckerTemplateSimple<MultmoipInfo> {

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
