package br.com.mind5.business.storeTextSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.business.storeTextSearch.model.decisionTree.StorextarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextarchVisiRootSelect extends ActionVisitorTemplateAction<StorextarchInfo, StorextarchInfo> {

	public StorextarchVisiRootSelect(DeciTreeOption<StorextarchInfo> option) {
		super(option, StorextarchInfo.class, StorextarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorextarchInfo>> getTreeClassHook() {
		return StorextarchRootSelect.class;
	}
	
	
	
	@Override protected List<StorextarchInfo> toBaseClassHook(List<StorextarchInfo> baseInfos, List<StorextarchInfo> results) {
		return results;
	}
}
