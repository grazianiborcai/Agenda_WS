package br.com.mind5.business.customer.model.checker;

import java.sql.Connection;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CusCheckInsert extends ModelCheckerTemplateSimple<CusInfo> {

	public CusCheckInsert(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner	<= 0	||
			 recordInfo.codUser		<= 0	||
			 recordInfo.personData 	== null ||
			 recordInfo.username 	== null ||
			 recordInfo.codLanguage == null 	)
				
			return super.FAILED;
			
			
			return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CUS_MANDATORY_FIELD_EMPTY;
	}
}
