package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info.SowotarchInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info.SowotarchSetterCalmonth;

public final class SowotarchVisiEnforceCalmonth extends ActionVisitorTemplateEnforce<SowotarchInfo> {
	
	public SowotarchVisiEnforceCalmonth(DeciTreeOption<SowotarchInfo> option) {
		super(option);
	}

	
	
	@Override protected SowotarchInfo enforceHook(SowotarchInfo recordInfo) {
		InfoSetter<SowotarchInfo> attrSetter = new SowotarchSetterCalmonth();
		return attrSetter.setAttr(recordInfo);
	}
}
