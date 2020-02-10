package br.com.mind5.payment.partnerMoip.customerMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckWrite extends ModelCheckerTemplateSimpleV2<CusmoipInfo> {

	public CusmoipCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusmoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codAddress 	<= 0 	||
			recordInfo.codPhone 	<= 0 	||
			recordInfo.codUser 		<= 0 	||
			recordInfo.compoundId 	== null		)
			
			return super.FAILED;

		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_CUS_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
