package br.com.mind5.business.storeNearby.model.action;

import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.info.StorbyPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePruneSelfV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorbyPruneEmpty extends ActionVisitorTemplatePruneSelfV2<StorbyInfo> {
	
	public VisiStorbyPruneEmpty(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<StorbyInfo> pruneHook(List<StorbyInfo> recordInfos) {	
		return StorbyPruner.pruneEmpty(recordInfos);
	}
}
