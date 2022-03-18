package br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonSetterZerofy;

public final class StefilonVisiEnforceZerofy extends ActionVisitorTemplateEnforce<StefilonInfo> {
	
	public StefilonVisiEnforceZerofy(DeciTreeOption<StefilonInfo> option) {
		super(option);
	}

	
	
	@Override protected StefilonInfo enforceHook(StefilonInfo recordInfo) {
		InfoSetter<StefilonInfo> attrSetter = new StefilonSetterZerofy();
		return attrSetter.setAttr(recordInfo);
	}
}
