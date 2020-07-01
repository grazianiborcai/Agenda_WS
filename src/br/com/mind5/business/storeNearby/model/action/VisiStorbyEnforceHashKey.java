package br.com.mind5.business.storeNearby.model.action;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.info.StorbySetterHashKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorbyEnforceHashKey extends ActionVisitorTemplateEnforceV2<StorbyInfo> {
	
	public VisiStorbyEnforceHashKey(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}

	
	
	@Override protected StorbyInfo enforceHook(StorbyInfo recordInfo) {
		InfoSetter<StorbyInfo> attrSetter = new StorbySetterHashKey();
		return attrSetter.setAttr(recordInfo);
	}
}
