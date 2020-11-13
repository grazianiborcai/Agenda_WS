package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckSetuparData extends ModelCheckerTemplateSimple<CusmoipInfo> {

	public CusmoipCheckSetuparData(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusmoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.setuparData == null)
			return super.FAILED;
		
		
		if (recordInfo.setuparData.basicKey   == null ||
			recordInfo.setuparData.basicToken == null	 )	
		
			return super.FAILED;
			
			
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_CUS_MOIP_SETUPAR_MISSING;
	}
}
