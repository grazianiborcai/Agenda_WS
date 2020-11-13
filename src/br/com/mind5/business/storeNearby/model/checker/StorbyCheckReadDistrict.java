package br.com.mind5.business.storeNearby.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StorbyCheckReadDistrict extends ModelCheckerTemplateSimple<StorbyInfo> {

	public StorbyCheckReadDistrict(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StorbyInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0 	||
			 recordInfo.districtSearch	== null ||
			 recordInfo.username		== null ||
			 recordInfo.codLanguage		== null		)	
			
			return super.FAILED;
		
		
		if ( recordInfo.latitude  == DefaultValue.geo() &&
			 recordInfo.longitude == DefaultValue.geo()		)	
					
			return super.FAILED;
		
		
		if ( recordInfo.districtSearch.length() < 3	)					
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_NEARBY_MANDATORY_FIELD_EMPTY;
	}
}
