package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.action.SowordarchVisiDaoSelect;

public final class SowordarchCheckExist extends ModelCheckerTemplateAction<SowordarchInfo, SowordarchInfo> {
	
	public SowordarchCheckExist(ModelCheckerOption option) {
		super(option, SowordarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<SowordarchInfo> buildActionHook(DeciTreeOption<SowordarchInfo> option) {
		ActionStd<SowordarchInfo> select = new ActionStdCommom<SowordarchInfo>(option, SowordarchVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_OWN_ODR_MTH_SRCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWN_ODR_MTH_SRCH_NOT_FOUND;
	}
}
