package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.action.StoroniveVisiDaoSelect;

public final class StoroniveCheckExist extends ModelCheckerTemplateAction<StoroniveInfo, StoroniveInfo> {
	
	public StoroniveCheckExist(ModelCheckerOption option) {
		super(option, StoroniveInfo.class);
	}
	
	
	
	@Override protected ActionStd<StoroniveInfo> buildActionHook(DeciTreeOption<StoroniveInfo> option) {
		ActionStd<StoroniveInfo> select = new ActionStdCommom<StoroniveInfo>(option, StoroniveVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_STR_ODR_MTH_LIVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STR_ODR_MTH_LIVE_NOT_FOUND;
	}
}
