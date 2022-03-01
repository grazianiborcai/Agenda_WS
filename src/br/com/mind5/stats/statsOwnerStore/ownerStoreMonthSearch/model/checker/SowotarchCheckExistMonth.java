package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info.SowotarchInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.decisionTree.SowotarchRootSelectMonth;

public final class SowotarchCheckExistMonth extends ModelCheckerTemplateAction<SowotarchInfo, SowotarchInfo> {
	
	public SowotarchCheckExistMonth(ModelCheckerOption option) {
		super(option, SowotarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<SowotarchInfo> buildActionHook(DeciTreeOption<SowotarchInfo> option) {
		ActionStd<SowotarchInfo> select = new SowotarchRootSelectMonth(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_OWN_STR_MTH_SRCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWN_STR_MTH_SRCH_NOT_FOUND;
	}
}
