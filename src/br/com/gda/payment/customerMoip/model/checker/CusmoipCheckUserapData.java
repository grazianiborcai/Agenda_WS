package br.com.gda.payment.customerMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckUserapData extends ModelCheckerTemplateSimple<CusmoipInfo> {

	public CusmoipCheckUserapData() {
		super();
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
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_CUS_MOIP_USERAP_MISSING;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_CUS_MOIP_USERAP_MISSING;
	}
}
