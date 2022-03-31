package br.com.mind5.business.storeFavorite.model.action;

import java.util.List;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.model.decisionTree.StoriteRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoriteVisiRootSelect extends ActionVisitorTemplateAction<StoriteInfo, StoriteInfo> {

	public StoriteVisiRootSelect(DeciTreeOption<StoriteInfo> option) {
		super(option, StoriteInfo.class, StoriteInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoriteInfo>> getTreeClassHook() {
		return StoriteRootSelect.class;
	}
	
	
	
	@Override protected List<StoriteInfo> toBaseClassHook(List<StoriteInfo> baseInfos, List<StoriteInfo> results) {
		return results;
	}
}
