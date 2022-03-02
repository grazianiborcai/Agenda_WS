package br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.info.SowusarchInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.model.action.SowusarchVisiRootSelect;

public final class SowusarchCheckExist extends ModelCheckerTemplateAction<SowusarchInfo, SowusarchInfo> {
	
	public SowusarchCheckExist(ModelCheckerOption option) {
		super(option, SowusarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<SowusarchInfo> buildActionHook(DeciTreeOption<SowusarchInfo> option) {
		ActionStd<SowusarchInfo> select = new ActionStdCommom<SowusarchInfo>(option, SowusarchVisiRootSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_OWN_USR_MTH_SRCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWN_USR_MTH_SRCH_NOT_FOUND;
	}
}
