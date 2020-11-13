package br.com.mind5.masterData.materialSubgroupSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialSubgroupSearch.info.MatubuparchInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatubuparchCheckRead extends ModelCheckerTemplateSimple<MatubuparchInfo> {

	public MatubuparchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatubuparchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage == null	)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_SUBGROUP_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
