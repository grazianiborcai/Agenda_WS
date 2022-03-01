package br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info.SowalagrInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info.SowalagrSetterLChanged;

public final class SowalagrVisiEnforceLChanged extends ActionVisitorTemplateEnforce<SowalagrInfo> {
	
	public SowalagrVisiEnforceLChanged(DeciTreeOption<SowalagrInfo> option) {
		super(option);
	}

	
	
	@Override protected SowalagrInfo enforceHook(SowalagrInfo recordInfo) {
		InfoSetter<SowalagrInfo> attrSetter = new SowalagrSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
