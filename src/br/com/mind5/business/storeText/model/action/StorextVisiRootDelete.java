package br.com.mind5.business.storeText.model.action;

import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.decisionTree.StorextRootDelete;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextVisiRootDelete extends ActionVisitorTemplateAction<StorextInfo, StorextInfo> {

	public StorextVisiRootDelete(DeciTreeOption<StorextInfo> option) {
		super(option, StorextInfo.class, StorextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorextInfo>> getTreeClassHook() {
		return StorextRootDelete.class;
	}
	
	
	
	@Override protected List<StorextInfo> toBaseClassHook(List<StorextInfo> baseInfos, List<StorextInfo> results) {
		return results;
	}
}
