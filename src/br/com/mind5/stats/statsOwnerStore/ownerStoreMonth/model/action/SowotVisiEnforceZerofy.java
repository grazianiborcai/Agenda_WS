package br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotSetterZerofy;

public final class SowotVisiEnforceZerofy extends ActionVisitorTemplateEnforce<SowotInfo> {
	
	public SowotVisiEnforceZerofy(DeciTreeOption<SowotInfo> option) {
		super(option);
	}

	
	
	@Override protected SowotInfo enforceHook(SowotInfo recordInfo) {
		InfoSetter<SowotInfo> attrSetter = new SowotSetterZerofy();
		return attrSetter.setAttr(recordInfo);
	}
}
