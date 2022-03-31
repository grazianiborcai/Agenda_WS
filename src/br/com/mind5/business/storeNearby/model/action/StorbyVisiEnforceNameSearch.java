package br.com.mind5.business.storeNearby.model.action;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.info.StorbySetterNameSearch;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorbyVisiEnforceNameSearch extends ActionVisitorTemplateEnforce<StorbyInfo> {
	
	public StorbyVisiEnforceNameSearch(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}

	
	
	@Override protected StorbyInfo enforceHook(StorbyInfo recordInfo) {
		InfoSetter<StorbyInfo> attrSetter = new StorbySetterNameSearch();
		return attrSetter.setAttr(recordInfo);
	}
	
	
	
	@Override protected boolean shouldUniquifyResult() {
		return super.UNIQUIFY_RESULTS;
	}
}
