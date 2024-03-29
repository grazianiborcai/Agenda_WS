package br.com.mind5.business.addressDefault.model.checker;

import java.sql.Connection;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class AddaultCheckReadUser extends ModelCheckerTemplateSimple<AddaultInfo> {

	public AddaultCheckReadUser(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(AddaultInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codUser 	<= 0	||
			 recordInfo.codLanguage	== null		)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_DEFAULT_MANDATORY_FIELD_EMPTY;
	}
}
