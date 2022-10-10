package br.com.mind5.geo.geoMapquest.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.geo.geoMapquest.info.GeoquestInfo;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class GeoquestCheckCoding extends ModelCheckerTemplateSimple<GeoquestInfo> {

	public GeoquestCheckCoding(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(GeoquestInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.location == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_MANDATORY_FIELD_EMPTY_M);
		builder.addParam01(SystemCode.GEO_MAP_QUEST);

		return builder.build();
	}
}
