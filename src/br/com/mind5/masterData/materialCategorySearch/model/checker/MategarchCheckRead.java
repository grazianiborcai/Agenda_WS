package br.com.mind5.masterData.materialCategorySearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialCategorySearch.info.MategarchInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MategarchCheckRead extends ModelCheckerTemplateSimple<MategarchInfo> {
	
	public MategarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MategarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage == null )	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_CATEG_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
