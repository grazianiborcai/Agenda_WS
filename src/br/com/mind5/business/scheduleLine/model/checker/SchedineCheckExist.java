package br.com.mind5.business.scheduleLine.model.checker;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineCheckExist extends ModelCheckerTemplateAction<SchedineInfo, SchedineInfo> {
	
	public SchedineCheckExist(ModelCheckerOption option) {
		super(option, SchedineInfo.class);
	}
	

	
	@Override protected ActionStdV1<SchedineInfo> buildActionHook(DeciTreeOption<SchedineInfo> option) {
		ActionStdV1<SchedineInfo> select = new StdSchedineSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SCHEDULE_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_NOT_FOUND;
	}
}
