package br.com.mind5.geo.geoCode.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.geo.geoCode.info.GeodeInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class GeodeCheckCoding extends ModelCheckerTemplateSimple<GeodeInfo> {

	public GeodeCheckCoding(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(GeodeInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.street		== null ||
			 recordInfo.district	== null ||
			 recordInfo.city		== null ||
			 recordInfo.codState	== null ||
			 recordInfo.codCountry	== null ||
			 recordInfo.username	== null ||
			 recordInfo.codLanguage	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.GEO_CODE_MANDATORY_FIELD_EMPTY;
	}
}
