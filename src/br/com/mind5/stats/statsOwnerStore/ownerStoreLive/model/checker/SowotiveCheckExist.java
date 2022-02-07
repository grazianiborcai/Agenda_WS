package br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info.SowotiveInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.action.StdSowotiveDaoSelect;

public final class SowotiveCheckExist extends ModelCheckerTemplateAction<SowotiveInfo, SowotiveInfo> {
	
	public SowotiveCheckExist(ModelCheckerOption option) {
		super(option, SowotiveInfo.class);
	}
	
	
	
	@Override protected ActionStd<SowotiveInfo> buildActionHook(DeciTreeOption<SowotiveInfo> option) {
		ActionStd<SowotiveInfo> select = new StdSowotiveDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_OWNER_STORE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWNER_STORE_LIVE_NOT_FOUND;
	}
}
