package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.action.CustamonagrVisiDaoSelect;

public final class CustamonagrCheckExist extends ModelCheckerTemplateAction<CustamonagrInfo, CustamonagrInfo> {
	
	public CustamonagrCheckExist(ModelCheckerOption option) {
		super(option, CustamonagrInfo.class);
	}
	
	
	
	@Override protected ActionStd<CustamonagrInfo> buildActionHook(DeciTreeOption<CustamonagrInfo> option) {
		ActionStd<CustamonagrInfo> select = new ActionStdCommom<CustamonagrInfo>(option, CustamonagrVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_CUS_SCH_MTH_AGGR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_CUS_SCH_MTH_AGGR_NOT_FOUND;
	}
}
