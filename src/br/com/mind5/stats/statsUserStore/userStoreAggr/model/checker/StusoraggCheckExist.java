package br.com.mind5.stats.statsUserStore.userStoreAggr.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreAggr.info.StusoraggInfo;
import br.com.mind5.stats.statsUserStore.userStoreAggr.model.action.StusoraggVisiDaoSelect;

public final class StusoraggCheckExist extends ModelCheckerTemplateAction<StusoraggInfo, StusoraggInfo> {
	
	public StusoraggCheckExist(ModelCheckerOption option) {
		super(option, StusoraggInfo.class);
	}
	
	
	
	@Override protected ActionStd<StusoraggInfo> buildActionHook(DeciTreeOption<StusoraggInfo> option) {
		ActionStd<StusoraggInfo> select = new ActionStdCommom<StusoraggInfo>(option, StusoraggVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_STORE_USER_AGGR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STORE_USER_AGGR_NOT_FOUND;
	}
}
