package br.com.mind5.business.scheduleLine.model.checker;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineCheckExist extends ModelCheckerTemplateActionV2<SchedineInfo, SchedineInfo> {
	
	public SchedineCheckExist(ModelCheckerOption option) {
		super(option, SchedineInfo.class);
	}
	

	
	@Override protected ActionStdV2<SchedineInfo> buildActionHook(DeciTreeOption<SchedineInfo> option) {
		ActionStdV2<SchedineInfo> select = new StdSchedineDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SCHEDULE_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_NOT_FOUND;
	}
}
