package br.com.mind5.masterData.scheduleStatus.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;
import br.com.mind5.masterData.scheduleStatus.model.action.StdSchedatusDaoSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedatusCheckExist extends ModelCheckerTemplateActionV2<SchedatusInfo, SchedatusInfo> {
	
	public SchedatusCheckExist(ModelCheckerOption option) {
		super(option, SchedatusInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<SchedatusInfo> buildActionHook(DeciTreeOption<SchedatusInfo> option) {
		ActionStdV1<SchedatusInfo> select = new StdSchedatusDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SCHEDULE_STATUS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_STATUS_NOT_FOUND;
	}
}
