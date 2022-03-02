package br.com.mind5.bot.botStats.botStatsOwner.model.checker;

import java.sql.Connection;

import br.com.mind5.bot.botStats.botStatsOwner.info.BostowInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class BostowCheckWriteL2m extends ModelCheckerTemplateSimple<BostowInfo> {

	public BostowCheckWriteL2m(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(BostowInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codLanguage 	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_BOT_OWNER_MANDATORY_FIELD_EMPTY;
	}
}
