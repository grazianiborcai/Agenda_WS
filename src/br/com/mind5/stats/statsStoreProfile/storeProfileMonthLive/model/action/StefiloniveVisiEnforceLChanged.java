package br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveSetterLChanged;

public final class StefiloniveVisiEnforceLChanged extends ActionVisitorTemplateEnforce<StefiloniveInfo> {
	
	public StefiloniveVisiEnforceLChanged(DeciTreeOption<StefiloniveInfo> option) {
		super(option);
	}

	
	
	@Override protected StefiloniveInfo enforceHook(StefiloniveInfo recordInfo) {
		InfoSetter<StefiloniveInfo> attrSetter = new StefiloniveSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
