package br.com.mind5.payment.customerPartner.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckInsert extends ModelCheckerTemplateSimpleV2<CusparInfo> {

	public CusparCheckInsert(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusparInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.codPayPartner <= 0	
			|| recordInfo.codUser 		<= 0	
			|| recordInfo.codAddress	<= 0 	
			|| recordInfo.codPhone		<= 0 	
			|| recordInfo.username		== null 
			|| recordInfo.codLanguage 	== null )
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_CUS_MANDATORY_FIELD_EMPTY;
	}
}
