package br.com.mind5.geo.geoHash.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.geo.geoHash.info.GeoshInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class GeoshCheckGenerate extends ModelCheckerTemplateSimpleV2<GeoshInfo> {

	public GeoshCheckGenerate(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(GeoshInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.latitude 	<= 0 	||
			 recordInfo.longitude	<= 0 	||
			 recordInfo.codLanguage	== null	||
			 recordInfo.username	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.GEO_HASH_MANDATORY_FIELD_EMPTY;
	}
}
