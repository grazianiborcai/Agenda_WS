package br.com.mind5.business.storeNearby.model.action;

import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.decisionTree.StorbyNodeMerge;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorbyVisiNodeMerge extends ActionVisitorTemplateAction<StorbyInfo, StorbyInfo> {

	public StorbyVisiNodeMerge(DeciTreeOption<StorbyInfo> option) {
		super(option, StorbyInfo.class, StorbyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorbyInfo>> getTreeClassHook() {
		return StorbyNodeMerge.class;
	}
	
	
	
	@Override protected List<StorbyInfo> toBaseClassHook(List<StorbyInfo> baseInfos, List<StorbyInfo> results) {
		return results;
	}
}
