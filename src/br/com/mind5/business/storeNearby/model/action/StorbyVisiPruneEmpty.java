package br.com.mind5.business.storeNearby.model.action;

import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.info.StorbyPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePruneSelf;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorbyVisiPruneEmpty extends ActionVisitorTemplatePruneSelf<StorbyInfo> {
	
	public StorbyVisiPruneEmpty(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<StorbyInfo> pruneHook(List<StorbyInfo> recordInfos) {	
		return StorbyPruner.pruneEmpty(recordInfos);
	}
}
