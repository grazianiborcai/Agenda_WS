package br.com.mind5.business.scheduleLine.model.checker;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineCheckExist extends ModelCheckerTemplateAction<SchedineInfo, SchedineInfo> {
	
	public SchedineCheckExist(ModelCheckerOption option) {
		super(option, SchedineInfo.class);
	}
	

	
	@Override protected ActionStd<SchedineInfo> buildActionHook(DeciTreeOption<SchedineInfo> option) {
		ActionStd<SchedineInfo> select = new  ActionStdCommom<SchedineInfo>(option, SchedineVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SCHEDULE_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_NOT_FOUND;
	}
}
