package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.masterData.model.decisionTree.ActionWeekdaySelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class WeekdayCheckExist extends ModelCheckerTemplateAction<WeekdayInfo> {
	
	public WeekdayCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<WeekdayInfo> buildActionHook(WeekdayInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<WeekdayInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<WeekdayInfo> actionSelect = new ActionWeekdaySelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<WeekdayInfo> buildActionOption(WeekdayInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<WeekdayInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.WEEKDAY_ALREADY_EXIST)
			return SystemMessage.WEEKDAY_ALREADY_EXIST;
		
		return SystemMessage.WEEKDAY_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.WEEKDAY_ALREADY_EXIST;	
			
		return SystemCode.WEEKDAY_NOT_FOUND;
	}
}
