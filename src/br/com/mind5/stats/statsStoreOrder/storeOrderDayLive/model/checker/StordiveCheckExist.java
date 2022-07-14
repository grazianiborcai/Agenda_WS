package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.action.StordiveVisiDaoSelect;

public final class StordiveCheckExist extends ModelCheckerTemplateAction<StordiveInfo, StordiveInfo> {
	
	public StordiveCheckExist(ModelCheckerOption option) {
		super(option, StordiveInfo.class);
	}
	
	
	
	@Override protected ActionStd<StordiveInfo> buildActionHook(DeciTreeOption<StordiveInfo> option) {
		ActionStd<StordiveInfo> select = new ActionStdCommom<StordiveInfo>(option, StordiveVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_STR_ODR_DAY_LIVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STR_ODR_DAY_LIVE_NOT_FOUND;
	}
}
