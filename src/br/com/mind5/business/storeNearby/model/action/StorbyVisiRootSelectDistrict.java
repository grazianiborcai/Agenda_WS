package br.com.mind5.business.storeNearby.model.action;

import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.decisionTree.StorbyRootSelectDistrict;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorbyVisiRootSelectDistrict extends ActionVisitorTemplateAction<StorbyInfo, StorbyInfo> {

	public StorbyVisiRootSelectDistrict(DeciTreeOption<StorbyInfo> option) {
		super(option, StorbyInfo.class, StorbyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorbyInfo>> getTreeClassHook() {
		return StorbyRootSelectDistrict.class;
	}
	
	
	
	@Override protected List<StorbyInfo> toBaseClassHook(List<StorbyInfo> baseInfos, List<StorbyInfo> results) {
		return results;
	}
}
