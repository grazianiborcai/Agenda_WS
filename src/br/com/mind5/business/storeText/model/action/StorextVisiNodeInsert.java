package br.com.mind5.business.storeText.model.action;

import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.decisionTree.StorextNodeInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextVisiNodeInsert extends ActionVisitorTemplateAction<StorextInfo, StorextInfo> {

	public StorextVisiNodeInsert(DeciTreeOption<StorextInfo> option) {
		super(option, StorextInfo.class, StorextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorextInfo>> getTreeClassHook() {
		return StorextNodeInsert.class;
	}
	
	
	
	@Override protected List<StorextInfo> toBaseClassHook(List<StorextInfo> baseInfos, List<StorextInfo> results) {
		return results;
	}
}
