package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class MultmoipCheckPay extends ModelCheckerTemplateSimple<MultmoipInfo> {

	public MultmoipCheckPay(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MultmoipInfo recordInfo, Connection conn, String schemaName) {			
		if ( recordInfo.codOwner 		<= 0	||		
			 recordInfo.codPayOrder 	<= 0	||	
			 recordInfo.codCreditCard	<= 0	||
			 recordInfo.cardCvc 		== null	||
			 recordInfo.codLanguage 	== null	||
			 recordInfo.username 		== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MULT_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
