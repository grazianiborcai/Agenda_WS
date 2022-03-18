package br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrSetterLChanged;

public final class StefilonagrVisiEnforceLChanged extends ActionVisitorTemplateEnforce<StefilonagrInfo> {
	
	public StefilonagrVisiEnforceLChanged(DeciTreeOption<StefilonagrInfo> option) {
		super(option);
	}

	
	
	@Override protected StefilonagrInfo enforceHook(StefilonagrInfo recordInfo) {
		InfoSetter<StefilonagrInfo> attrSetter = new StefilonagrSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
