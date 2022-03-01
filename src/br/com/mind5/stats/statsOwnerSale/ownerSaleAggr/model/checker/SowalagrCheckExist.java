package br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info.SowalagrInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.model.action.SowalagrVisiDaoSelect;

public final class SowalagrCheckExist extends ModelCheckerTemplateAction<SowalagrInfo, SowalagrInfo> {
	
	public SowalagrCheckExist(ModelCheckerOption option) {
		super(option, SowalagrInfo.class);
	}
	
	
	
	@Override protected ActionStd<SowalagrInfo> buildActionHook(DeciTreeOption<SowalagrInfo> option) {
		ActionStd<SowalagrInfo> select = new ActionStdCommom<SowalagrInfo>(option, SowalagrVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_OWN_SALE_AGGR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWN_SALE_AGGR_NOT_FOUND;
	}
}
