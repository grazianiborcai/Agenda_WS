package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.action.StdStordagrDaoSelect;

public final class StordagrCheckExist extends ModelCheckerTemplateAction<StordagrInfo, StordagrInfo> {
	
	public StordagrCheckExist(ModelCheckerOption option) {
		super(option, StordagrInfo.class);
	}
	
	
	
	@Override protected ActionStd<StordagrInfo> buildActionHook(DeciTreeOption<StordagrInfo> option) {
		ActionStd<StordagrInfo> select = new StdStordagrDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_STR_ODR_DAY_AGGR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STR_ODR_DAY_AGGR_NOT_FOUND;
	}
}
