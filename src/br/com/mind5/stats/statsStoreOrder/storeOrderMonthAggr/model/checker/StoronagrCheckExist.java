package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.action.StdStoronagrDaoSelect;

public final class StoronagrCheckExist extends ModelCheckerTemplateAction<StoronagrInfo, StoronagrInfo> {
	
	public StoronagrCheckExist(ModelCheckerOption option) {
		super(option, StoronagrInfo.class);
	}
	
	
	
	@Override protected ActionStd<StoronagrInfo> buildActionHook(DeciTreeOption<StoronagrInfo> option) {
		ActionStd<StoronagrInfo> select = new StdStoronagrDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_STR_ODR_MTH_AGGR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STR_ODR_MTH_AGGR_NOT_FOUND;
	}
}
