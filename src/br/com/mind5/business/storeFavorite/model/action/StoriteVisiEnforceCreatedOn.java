package br.com.mind5.business.storeFavorite.model.action;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.info.StoriteSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoriteVisiEnforceCreatedOn extends ActionVisitorTemplateEnforce<StoriteInfo> {
	
	public StoriteVisiEnforceCreatedOn(DeciTreeOption<StoriteInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StoriteInfo enforceHook(StoriteInfo recordInfo) {
		InfoSetter<StoriteInfo> attrSetter = new StoriteSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
