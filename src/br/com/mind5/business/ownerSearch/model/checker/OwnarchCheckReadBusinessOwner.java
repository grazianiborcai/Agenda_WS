package br.com.mind5.business.ownerSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class OwnarchCheckReadBusinessOwner extends ModelCheckerTemplateSimple<OwnarchInfo> {

	public OwnarchCheckReadBusinessOwner(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OwnarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner  	<= 0	||
			 recordInfo.codBusiness <= 0	||
			 recordInfo.codLanguage == null)
			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.OWNER_SEARCH_MANDATORY_FIELD_EMPTY;
	}	
}
