package br.com.mind5.business.storeFavorite.model.action;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.info.StoriteSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoriteEnforceLChanged extends ActionVisitorTemplateEnforceV2<StoriteInfo> {
	
	public VisiStoriteEnforceLChanged(DeciTreeOption<StoriteInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StoriteInfo enforceHook(StoriteInfo recordInfo) {
		InfoSetter<StoriteInfo> attrSetter = new StoriteSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
