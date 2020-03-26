package br.com.mind5.business.owner.model.checker;

import java.sql.Connection;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class OwnerCheckUpdate extends ModelCheckerTemplateSimple<OwnerInfo> {

	public OwnerCheckUpdate(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OwnerInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.username 	== null ||
			 recordInfo.codLanguage == null		)
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.OWNER_MANDATORY_FIELD_EMPTY;
	}
}
