package br.com.mind5.business.scheduleYearData.model.checker;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.business.scheduleYearData.model.action.StdSchedyeratDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedyeratCheckExist extends ModelCheckerTemplateAction<SchedyeratInfo, SchedyeratInfo> {
	
	public SchedyeratCheckExist(ModelCheckerOption option) {
		super(option, SchedyeratInfo.class);
	}
	
	
	
	@Override protected ActionStd<SchedyeratInfo> buildActionHook(DeciTreeOption<SchedyeratInfo> option) {
		ActionStd<SchedyeratInfo> select = new StdSchedyeratDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SCHEDULE_YEAR_DATA_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_YEAR_DATA_NOT_FOUND;
	}
}
