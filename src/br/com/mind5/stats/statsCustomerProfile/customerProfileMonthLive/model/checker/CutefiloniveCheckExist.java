package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.action.CutefiloniveVisiDaoSelect;

public final class CutefiloniveCheckExist extends ModelCheckerTemplateAction<CutefiloniveInfo, CutefiloniveInfo> {
	
	public CutefiloniveCheckExist(ModelCheckerOption option) {
		super(option, CutefiloniveInfo.class);
	}
	
	
	
	@Override protected ActionStd<CutefiloniveInfo> buildActionHook(DeciTreeOption<CutefiloniveInfo> option) {
		ActionStd<CutefiloniveInfo> select = new ActionStdCommom<CutefiloniveInfo>(option, CutefiloniveVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_CUS_PRF_MTH_LIVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_CUS_PRF_MTH_LIVE_NOT_FOUND;
	}
}
