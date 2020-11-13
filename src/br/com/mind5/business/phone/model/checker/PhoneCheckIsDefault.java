package br.com.mind5.business.phone.model.checker;

import java.sql.Connection;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PhoneCheckIsDefault extends ModelCheckerTemplateSimple<PhoneInfo> {

	public PhoneCheckIsDefault(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PhoneInfo recordInfo, Connection conn, String schemaName) {			
		return recordInfo.isDefault;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_NOT_DEFAULT;
	}
}
