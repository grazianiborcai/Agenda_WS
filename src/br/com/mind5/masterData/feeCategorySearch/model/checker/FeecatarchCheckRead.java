package br.com.mind5.masterData.feeCategorySearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.feeCategorySearch.info.FeecatarchInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class FeecatarchCheckRead extends ModelCheckerTemplateSimple<FeecatarchInfo> {
	
	public FeecatarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FeecatarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FEE_CATEG_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
