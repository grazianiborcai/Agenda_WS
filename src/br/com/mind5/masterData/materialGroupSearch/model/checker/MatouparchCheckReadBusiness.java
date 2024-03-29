package br.com.mind5.masterData.materialGroupSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatouparchCheckReadBusiness extends ModelCheckerTemplateSimple<MatouparchInfo> {

	public MatouparchCheckReadBusiness(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatouparchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage == null ||
			 recordInfo.codBusiness <= 0		)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_GROUP_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
