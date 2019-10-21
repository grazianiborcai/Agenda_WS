package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.business.masterData.model.action.StdWeekdaySelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class WeekdayCheckExist extends ModelCheckerTemplateAction_<WeekdayInfo> {
	
	public WeekdayCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<WeekdayInfo> buildActionHook(WeekdayInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<WeekdayInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<WeekdayInfo> actionSelect = new StdWeekdaySelect(option);
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
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.WEEKDAY_ALREADY_EXIST)
			return SystemMessage.WEEKDAY_ALREADY_EXIST;
		
		return SystemMessage.WEEKDAY_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.WEEKDAY_ALREADY_EXIST;	
			
		return SystemCode.WEEKDAY_NOT_FOUND;
	}
}
