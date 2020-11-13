package br.com.mind5.business.storeFavorite.model.action;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.info.StoriteSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoriteEnforceCreatedOn extends ActionVisitorTemplateEnforce<StoriteInfo> {
	
	public VisiStoriteEnforceCreatedOn(DeciTreeOption<StoriteInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StoriteInfo enforceHook(StoriteInfo recordInfo) {
		InfoSetter<StoriteInfo> attrSetter = new StoriteSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
