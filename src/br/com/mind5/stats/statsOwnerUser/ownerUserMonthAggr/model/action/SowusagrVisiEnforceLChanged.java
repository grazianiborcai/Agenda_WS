package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrSetterLChanged;

public final class SowusagrVisiEnforceLChanged extends ActionVisitorTemplateEnforce<SowusagrInfo> {
	
	public SowusagrVisiEnforceLChanged(DeciTreeOption<SowusagrInfo> option) {
		super(option);
	}

	
	
	@Override protected SowusagrInfo enforceHook(SowusagrInfo recordInfo) {
		InfoSetter<SowusagrInfo> attrSetter = new SowusagrSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
