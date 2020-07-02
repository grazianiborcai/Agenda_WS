package br.com.mind5.business.storeNearby.model.action;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.info.StorbySetterHash03Key;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorbyEnforceHash03Key extends ActionVisitorTemplateEnforceV2<StorbyInfo> {
	
	public VisiStorbyEnforceHash03Key(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}

	
	
	@Override protected StorbyInfo enforceHook(StorbyInfo recordInfo) {
		InfoSetter<StorbyInfo> attrSetter = new StorbySetterHash03Key();
		return attrSetter.setAttr(recordInfo);
	}
	
	
	
	@Override protected boolean shouldUniquifyResult() {
		return super.UNIQUIFY_RESULTS;
	}
}
