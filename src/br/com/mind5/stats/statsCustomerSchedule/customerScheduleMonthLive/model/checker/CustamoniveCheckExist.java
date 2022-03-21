package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.action.CustamoniveVisiDaoSelect;

public final class CustamoniveCheckExist extends ModelCheckerTemplateAction<CustamoniveInfo, CustamoniveInfo> {
	
	public CustamoniveCheckExist(ModelCheckerOption option) {
		super(option, CustamoniveInfo.class);
	}
	
	
	
	@Override protected ActionStd<CustamoniveInfo> buildActionHook(DeciTreeOption<CustamoniveInfo> option) {
		ActionStd<CustamoniveInfo> select = new ActionStdCommom<CustamoniveInfo>(option, CustamoniveVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_CUS_SCH_MTH_LIVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_CUS_SCH_MTH_LIVE_NOT_FOUND;
	}
}
