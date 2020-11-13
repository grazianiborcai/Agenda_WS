package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckUserData extends ModelCheckerTemplateSimple<CusmoipInfo> {

	public CusmoipCheckUserData(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusmoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.userapData == null)
			return super.FAILED;
		
		
		if (recordInfo.userapData.personData == null)
			return super.FAILED;
		
		
		if (recordInfo.userapData.personData.name   	== null ||
			recordInfo.userapData.personData.email 		== null	||
			recordInfo.userapData.personData.birthDate	== null	||
			recordInfo.userapData.personData.cpf		== null		)	
		
			return super.FAILED;
			
			
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_CUS_MOIP_USERAP_MISSING;
	}
}
