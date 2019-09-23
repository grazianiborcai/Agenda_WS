package br.com.gda.business.phoneSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class PhonapCheckHasUser extends ModelCheckerTemplateSimpleV2<PhonapInfo> {

	public PhonapCheckHasUser(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PhonapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner <= 0 ||
			 recordInfo.codUser  <= 0  )		
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_SNAPSHOT_USER_IS_EMPTY;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PHONE_SNAPSHOT_USER_IS_FILLED;
	}
}
