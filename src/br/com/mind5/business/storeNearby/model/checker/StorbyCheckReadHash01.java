package br.com.mind5.business.storeNearby.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class StorbyCheckReadHash01 extends ModelCheckerTemplateSimpleV2<StorbyInfo> {

	public StorbyCheckReadHash01(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StorbyInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.geoHash01	== null ||
			 recordInfo.username	== null ||
			 recordInfo.codLanguage	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_NEARBY_MANDATORY_FIELD_EMPTY;
	}
}
