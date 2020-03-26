package br.com.mind5.payment.customerPartnerSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;

public final class CusparchCheckRead extends ModelCheckerTemplateSimple<CusparchInfo> {

	public CusparchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusparchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0 	|| 
			 recordInfo.username		== null	||					 
			 recordInfo.codLanguage		== null		)
			
			return super.FAILED;
		
		
		if ( recordInfo.codUser 		<= 0 	&& 
			 recordInfo.codPayCustomer	<= 0 	&&					 
			 recordInfo.codPayPartner	<= 0 		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_CUS_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
