package br.com.mind5.business.scheduleSearch.model.checker;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.business.scheduleSearch.model.decisionTree.RootSchedarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedarchCheckExist extends ModelCheckerTemplateActionV2<SchedarchInfo, SchedarchInfo> {
	
	public SchedarchCheckExist(ModelCheckerOption option) {
		super(option, SchedarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<SchedarchInfo> buildActionHook(DeciTreeOption<SchedarchInfo> option) {
		ActionStdV1<SchedarchInfo> select = new RootSchedarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SCHEDULE_SEARCH_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_SEARCH_NOT_FOUND;
	}
}
