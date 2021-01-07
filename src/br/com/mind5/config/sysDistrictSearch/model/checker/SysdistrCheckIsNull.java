package br.com.mind5.config.sysDistrictSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.config.sysDistrictSearch.info.SysdistrInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class SysdistrCheckIsNull extends ModelCheckerTemplateSimple<SysdistrInfo> {

	public SysdistrCheckIsNull(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SysdistrInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.districtSearchDefault == null )				
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_DISTRICT_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
