package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrSetterLChanged;

public final class SowotagrVisiEnforceLChanged extends ActionVisitorTemplateEnforce<SowotagrInfo> {
	
	public SowotagrVisiEnforceLChanged(DeciTreeOption<SowotagrInfo> option) {
		super(option);
	}

	
	
	@Override protected SowotagrInfo enforceHook(SowotagrInfo recordInfo) {
		InfoSetter<SowotagrInfo> attrSetter = new SowotagrSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
