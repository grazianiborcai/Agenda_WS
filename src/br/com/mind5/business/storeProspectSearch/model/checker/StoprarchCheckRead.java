package br.com.mind5.business.storeProspectSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class StoprarchCheckRead extends ModelCheckerTemplateSimpleV2<StoprarchInfo> {

	public StoprarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoprarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 			<= 0 	|| 
			recordInfo.codLanguage 			== null		)	
			
			return super.FAILED;
		
		
		if (recordInfo.codStoreProspect 	<= 0 	&& 
			recordInfo.prospectEmail 		== null	&&
			recordInfo.codProspectStatus 	== null		)	
				
				return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_PROSPECT_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
