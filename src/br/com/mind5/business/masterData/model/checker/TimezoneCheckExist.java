package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.business.masterData.model.action.StdTimezoneSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class TimezoneCheckExist extends ModelCheckerTemplateAction_<TimezoneInfo> {	
	
	public TimezoneCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<TimezoneInfo> buildActionHook(TimezoneInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<TimezoneInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<TimezoneInfo> actionSelect = new StdTimezoneSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<TimezoneInfo> buildActionOption(TimezoneInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<TimezoneInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.TIMEZONE_ALREADY_EXIST)
			return SystemMessage.TIMEZONE_ALREADY_EXIST;
		
		return SystemMessage.TIMEZONE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.TIMEZONE_ALREADY_EXIST;	
			
		return SystemCode.TIMEZONE_NOT_FOUND;
	}
}
