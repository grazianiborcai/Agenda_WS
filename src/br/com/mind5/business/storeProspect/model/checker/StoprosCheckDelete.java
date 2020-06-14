package br.com.mind5.business.storeProspect.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class StoprosCheckDelete extends ModelCheckerTemplateSimpleV2<StoprosInfo> {

	public StoprosCheckDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoprosInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 			<= 0 
			|| recordInfo.codStoreProspect 	<= 0 
			|| recordInfo.codLanguage 		== null	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook(){
		return SystemCode.STORE_PROSPECT_MANDATORY_FIELD_EMPTY;
	}
}
