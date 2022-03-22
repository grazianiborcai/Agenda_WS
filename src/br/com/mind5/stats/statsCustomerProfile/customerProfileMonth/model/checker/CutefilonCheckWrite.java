package br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonInfo;

public final class CutefilonCheckWrite extends ModelCheckerTemplateSimple<CutefilonInfo> {

	public CutefilonCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CutefilonInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codCustomer 	<= 0 	||
			recordInfo.calmonth 	== null	||
			recordInfo.codLanguage 	== null	||
			recordInfo.username 	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_CUS_PRF_MTH_MANDATORY_FIELD_EMPTY;
	}
}
