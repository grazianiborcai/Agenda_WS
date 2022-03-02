package br.com.mind5.bot.botStats.botStatsStore.model.checker;

import java.sql.Connection;

import br.com.mind5.bot.botStats.botStatsStore.info.BostodInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class BostodCheckWriteL2m extends ModelCheckerTemplateSimple<BostodInfo> {

	public BostodCheckWriteL2m(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(BostodInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codLanguage 	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_BOT_STORE_MANDATORY_FIELD_EMPTY;
	}
}
