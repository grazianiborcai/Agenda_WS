package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.masterData.info.ScheduleStatusInfo;
import br.com.mind5.business.masterData.model.action.StdScheduleStatusSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class ScheduleStatusCheckExist extends ModelCheckerTemplateAction_<ScheduleStatusInfo> {
	
	public ScheduleStatusCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<ScheduleStatusInfo> buildActionHook(ScheduleStatusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<ScheduleStatusInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<ScheduleStatusInfo> actionSelect = new StdScheduleStatusSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<ScheduleStatusInfo> buildActionOption(ScheduleStatusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<ScheduleStatusInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.SCHEDULE_STATUS_ALREADY_EXIST)
			return SystemMessage.SCHEDULE_STATUS_ALREADY_EXIST;
		
		return SystemMessage.SCHEDULE_STATUS_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.SCHEDULE_STATUS_ALREADY_EXIST;	
			
		return SystemCode.SCHEDULE_STATUS_NOT_FOUND;
	}
}
