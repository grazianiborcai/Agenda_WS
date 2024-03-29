package br.com.mind5.business.storeSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class SotarchCheckHasName extends ModelCheckerTemplateSimple<SotarchInfo> {

	public SotarchCheckHasName(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SotarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.nameSearch == null )				
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
