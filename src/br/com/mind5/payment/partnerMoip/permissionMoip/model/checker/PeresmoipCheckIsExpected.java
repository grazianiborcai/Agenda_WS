package br.com.mind5.payment.partnerMoip.permissionMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class PeresmoipCheckIsExpected extends ModelCheckerTemplateSimpleV2<PeresmoipInfo> {

	public PeresmoipCheckIsExpected(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PeresmoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.isExpected)			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MOIP_PERM_RESP_IS_NOT_EXPECTED;
	}
}
