package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckWrite extends ModelCheckerTemplateSimple<CusmoipInfo> {

	public CusmoipCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusmoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 			<= 0 	||
			recordInfo.codAddressSnapshot 	<= 0 	||
			recordInfo.codPhoneSnapshot 	<= 0 	||
			recordInfo.codUserSnapshot 		<= 0 	||
			recordInfo.compoundId 			== null	||
			recordInfo.username				== null	||
			recordInfo.codLanguage			== null		)
			
			return super.FAILED;

		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_CUS_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
