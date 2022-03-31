package br.com.mind5.business.storeFavorite.model.action;

import java.util.List;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.model.decisionTree.StoriteRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoriteVisiRootInsert extends ActionVisitorTemplateAction<StoriteInfo, StoriteInfo> {

	public StoriteVisiRootInsert(DeciTreeOption<StoriteInfo> option) {
		super(option, StoriteInfo.class, StoriteInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoriteInfo>> getTreeClassHook() {
		return StoriteRootInsert.class;
	}
	
	
	
	@Override protected List<StoriteInfo> toBaseClassHook(List<StoriteInfo> baseInfos, List<StoriteInfo> results) {
		return results;
	}
}
