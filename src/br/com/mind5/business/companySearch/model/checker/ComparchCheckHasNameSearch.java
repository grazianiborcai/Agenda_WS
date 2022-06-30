package br.com.mind5.business.companySearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class ComparchCheckHasNameSearch extends ModelCheckerTemplateSimple<ComparchInfo> {

	public ComparchCheckHasNameSearch(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(ComparchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.nameSearch	== null )			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COMPANY_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
