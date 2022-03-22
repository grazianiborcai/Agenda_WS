package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.action.CutefilonagrVisiDaoSelect;

public final class CutefilonagrCheckExist extends ModelCheckerTemplateAction<CutefilonagrInfo, CutefilonagrInfo> {
	
	public CutefilonagrCheckExist(ModelCheckerOption option) {
		super(option, CutefilonagrInfo.class);
	}
	
	
	
	@Override protected ActionStd<CutefilonagrInfo> buildActionHook(DeciTreeOption<CutefilonagrInfo> option) {
		ActionStd<CutefilonagrInfo> select = new ActionStdCommom<CutefilonagrInfo>(option, CutefilonagrVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_CUS_PRF_MTH_AGGR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_CUS_PRF_MTH_AGGR_NOT_FOUND;
	}
}
