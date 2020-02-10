package br.com.mind5.payment.partnerMoip.customerMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckUserData extends ModelCheckerTemplateSimpleV2<CusmoipInfo> {

	public CusmoipCheckUserData(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusmoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.uselisData == null)
			return super.FAILED;
		
		
		if (recordInfo.uselisData.persolisData == null)
			return super.FAILED;
		
		
		if (recordInfo.uselisData.persolisData.name   		== null ||
			recordInfo.uselisData.persolisData.email 		== null	||
			recordInfo.uselisData.persolisData.birthDate	== null	||
			recordInfo.uselisData.persolisData.cpf			== null		)	
		
			return super.FAILED;
			
			
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_CUS_MOIP_USERAP_MISSING;
	}
}
