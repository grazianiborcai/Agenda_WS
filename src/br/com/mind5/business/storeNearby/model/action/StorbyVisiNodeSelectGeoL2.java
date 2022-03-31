package br.com.mind5.business.storeNearby.model.action;

import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.decisionTree.StorbyNodeSelectGeoL2;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorbyVisiNodeSelectGeoL2 extends ActionVisitorTemplateAction<StorbyInfo, StorbyInfo> {

	public StorbyVisiNodeSelectGeoL2(DeciTreeOption<StorbyInfo> option) {
		super(option, StorbyInfo.class, StorbyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorbyInfo>> getTreeClassHook() {
		return StorbyNodeSelectGeoL2.class;
	}
	
	
	
	@Override protected List<StorbyInfo> toBaseClassHook(List<StorbyInfo> baseInfos, List<StorbyInfo> results) {
		return results;
	}
}
