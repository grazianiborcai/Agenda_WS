package br.com.mind5.business.scheduleMonthData.model.checker;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.scheduleMonthData.model.action.StdSchedonthatDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedonthatCheckExist extends ModelCheckerTemplateActionV2<SchedonthatInfo, SchedonthatInfo> {
	
	public SchedonthatCheckExist(ModelCheckerOption option) {
		super(option, SchedonthatInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<SchedonthatInfo> buildActionHook(DeciTreeOption<SchedonthatInfo> option) {
		ActionStdV2<SchedonthatInfo> select = new StdSchedonthatDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SCHEDULE_MONTH_DATA_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_MONTH_DATA_NOT_FOUND;
	}
}
