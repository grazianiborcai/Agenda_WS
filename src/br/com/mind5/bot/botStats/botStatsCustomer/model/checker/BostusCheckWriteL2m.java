package br.com.mind5.bot.botStats.botStatsCustomer.model.checker;

import java.sql.Connection;

import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class BostusCheckWriteL2m extends ModelCheckerTemplateSimple<BostusInfo> {

	public BostusCheckWriteL2m(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(BostusInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codLanguage 	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_BOT_STORE_MANDATORY_FIELD_EMPTY;
	}
}
