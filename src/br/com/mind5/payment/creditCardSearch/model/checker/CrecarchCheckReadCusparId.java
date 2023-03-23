package br.com.mind5.payment.creditCardSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;

public final class CrecarchCheckReadCusparId extends ModelCheckerTemplateSimple<CrecarchInfo> {

	public CrecarchCheckReadCusparId(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CrecarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	    <= 0 	||
			 recordInfo.codUser 	    <= 0 	||
			 recordInfo.codLanguage	    == null	||
			 recordInfo.creditCardId	== null ||
			 recordInfo.codPayCustomer 	<= 0 	   )			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
