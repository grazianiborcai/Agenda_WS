package br.com.mind5.business.storeNearby.model.action;

import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.decisionTree.StorbyNodeSelectHash01;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorbyVisiNodeSelectHash01 extends ActionVisitorTemplateAction<StorbyInfo, StorbyInfo> {

	public StorbyVisiNodeSelectHash01(DeciTreeOption<StorbyInfo> option) {
		super(option, StorbyInfo.class, StorbyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorbyInfo>> getTreeClassHook() {
		return StorbyNodeSelectHash01.class;
	}
	
	
	
	@Override protected List<StorbyInfo> toBaseClassHook(List<StorbyInfo> baseInfos, List<StorbyInfo> results) {
		return results;
	}
}
