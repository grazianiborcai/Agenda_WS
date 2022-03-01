package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info.SowotarchInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.action.SowotarchVisiRootSelect;

public final class SowotarchCheckExist extends ModelCheckerTemplateAction<SowotarchInfo, SowotarchInfo> {
	
	public SowotarchCheckExist(ModelCheckerOption option) {
		super(option, SowotarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<SowotarchInfo> buildActionHook(DeciTreeOption<SowotarchInfo> option) {
		ActionStd<SowotarchInfo> select = new ActionStdCommom<SowotarchInfo>(option, SowotarchVisiRootSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_OWN_STR_MTH_SRCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWN_STR_MTH_SRCH_NOT_FOUND;
	}
}
