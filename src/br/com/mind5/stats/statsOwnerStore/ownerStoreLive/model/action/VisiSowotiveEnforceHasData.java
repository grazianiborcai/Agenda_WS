package br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info.SowotiveInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info.SowotiveSetterHasData;

final class VisiSowotiveEnforceHasData extends ActionVisitorTemplateEnforce<SowotiveInfo> {
	
	public VisiSowotiveEnforceHasData(DeciTreeOption<SowotiveInfo> option) {
		super(option);
	}

	
	
	@Override protected SowotiveInfo enforceHook(SowotiveInfo recordInfo) {
		InfoSetter<SowotiveInfo> attrSetter = new SowotiveSetterHasData();
		return attrSetter.setAttr(recordInfo);
	}
}
