package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.decisionTree.SowordarchRootSelectMonth;

public final class SowordarchCheckExistMonth extends ModelCheckerTemplateAction<SowordarchInfo, SowordarchInfo> {
	
	public SowordarchCheckExistMonth(ModelCheckerOption option) {
		super(option, SowordarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<SowordarchInfo> buildActionHook(DeciTreeOption<SowordarchInfo> option) {
		ActionStd<SowordarchInfo> select = new SowordarchRootSelectMonth(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_OWN_ODR_MTH_SRCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWN_ODR_MTH_SRCH_NOT_FOUND;
	}
}
