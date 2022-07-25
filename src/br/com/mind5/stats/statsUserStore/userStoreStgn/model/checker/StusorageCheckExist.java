package br.com.mind5.stats.statsUserStore.userStoreStgn.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreStgn.info.StusorageInfo;
import br.com.mind5.stats.statsUserStore.userStoreStgn.model.action.StusorageVisiDaoSelect;

public final class StusorageCheckExist extends ModelCheckerTemplateAction<StusorageInfo, StusorageInfo> {
	
	public StusorageCheckExist(ModelCheckerOption option) {
		super(option, StusorageInfo.class);
	}
	
	
	
	@Override protected ActionStd<StusorageInfo> buildActionHook(DeciTreeOption<StusorageInfo> option) {
		ActionStd<StusorageInfo> select = new ActionStdCommom<StusorageInfo>(option, StusorageVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_STORE_USER_STGN_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STORE_USER_STGN_NOT_FOUND;
	}
}
