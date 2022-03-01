package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.info.SowordiveInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.model.action.SowordiveVisiDaoSelect;

public final class SowordiveCheckExist extends ModelCheckerTemplateAction<SowordiveInfo, SowordiveInfo> {
	
	public SowordiveCheckExist(ModelCheckerOption option) {
		super(option, SowordiveInfo.class);
	}
	
	
	
	@Override protected ActionStd<SowordiveInfo> buildActionHook(DeciTreeOption<SowordiveInfo> option) {
		ActionStd<SowordiveInfo> select = new ActionStdCommom<SowordiveInfo>(option, SowordiveVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_OWNER_ORDER_LIVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWNER_ORDER_LIVE_NOT_FOUND;
	}
}
