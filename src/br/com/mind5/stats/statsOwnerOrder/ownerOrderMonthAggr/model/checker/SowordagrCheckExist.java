package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.action.StdSowordagrDaoSelect;

public final class SowordagrCheckExist extends ModelCheckerTemplateAction<SowordagrInfo, SowordagrInfo> {
	
	public SowordagrCheckExist(ModelCheckerOption option) {
		super(option, SowordagrInfo.class);
	}
	
	
	
	@Override protected ActionStd<SowordagrInfo> buildActionHook(DeciTreeOption<SowordagrInfo> option) {
		ActionStd<SowordagrInfo> select = new StdSowordagrDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_OWN_ODR_MTH_AGGR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWN_ODR_MTH_AGGR_NOT_FOUND;
	}
}
