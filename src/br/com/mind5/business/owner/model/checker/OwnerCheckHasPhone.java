package br.com.mind5.business.owner.model.checker;

import java.sql.Connection;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class OwnerCheckHasPhone extends ModelCheckerTemplateSimple<OwnerInfo> {
	
	public OwnerCheckHasPhone(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OwnerInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.phones == null)			
			return super.FAILED;		
		
		if (recordInfo.phones.isEmpty())			
			return super.FAILED;	
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.OWNER_PERSON_IS_EMPTY;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.OWNER_PERSON_IS_FILLED;
	}
}
