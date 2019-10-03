package br.com.gda.business.store.model.checker;

import java.sql.Connection;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class StoreCheckWrite extends ModelCheckerTemplateSimpleV2<StoreInfo> {

	public StoreCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoreInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 
			|| recordInfo.personData 	== null 	
			|| recordInfo.companyData 	== null
			|| recordInfo.codLanguage 	== null
			|| recordInfo.codCurr 		== null
			|| recordInfo.username 		== null 
			|| recordInfo.codTimezone	== null	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook(){
		return SystemCode.STORE_MANDATORY_FIELD_EMPTY;
	}
}
