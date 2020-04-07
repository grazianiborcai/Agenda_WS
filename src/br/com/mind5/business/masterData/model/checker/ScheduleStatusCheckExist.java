package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.ScheduleStatusInfo;
import br.com.mind5.business.masterData.model.action.StdScheduleStatusSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class ScheduleStatusCheckExist extends ModelCheckerTemplateActionV2<ScheduleStatusInfo, ScheduleStatusInfo> {
	
	public ScheduleStatusCheckExist(ModelCheckerOption option) {
		super(option, ScheduleStatusInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<ScheduleStatusInfo> buildActionHook(DeciTreeOption<ScheduleStatusInfo> option) {
		ActionStdV1<ScheduleStatusInfo> select = new StdScheduleStatusSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SCHEDULE_STATUS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_STATUS_NOT_FOUND;
	}
}
