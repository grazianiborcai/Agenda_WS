package br.com.mind5.masterData.scheduleStatus.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;
import br.com.mind5.masterData.scheduleStatus.model.action.StdSchedatusDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedatusCheckExist extends ModelCheckerTemplateAction<SchedatusInfo, SchedatusInfo> {
	
	public SchedatusCheckExist(ModelCheckerOption option) {
		super(option, SchedatusInfo.class);
	}
	
	
	
	@Override protected ActionStd<SchedatusInfo> buildActionHook(DeciTreeOption<SchedatusInfo> option) {
		ActionStd<SchedatusInfo> select = new StdSchedatusDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SCHEDULE_STATUS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_STATUS_NOT_FOUND;
	}
}
