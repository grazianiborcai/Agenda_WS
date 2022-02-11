package br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info.SowaliveInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action.StdSowaliveDaoSelect;

public final class SowaliveCheckExist extends ModelCheckerTemplateAction<SowaliveInfo, SowaliveInfo> {
	
	public SowaliveCheckExist(ModelCheckerOption option) {
		super(option, SowaliveInfo.class);
	}
	
	
	
	@Override protected ActionStd<SowaliveInfo> buildActionHook(DeciTreeOption<SowaliveInfo> option) {
		ActionStd<SowaliveInfo> select = new StdSowaliveDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_OWNER_SALE_LIVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWNER_SALE_LIVE_NOT_FOUND;
	}
}
