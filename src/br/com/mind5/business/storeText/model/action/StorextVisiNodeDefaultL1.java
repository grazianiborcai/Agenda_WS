package br.com.mind5.business.storeText.model.action;

import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.decisionTree.StorextNodeDefaultL1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextVisiNodeDefaultL1 extends ActionVisitorTemplateAction<StorextInfo, StorextInfo> {

	public StorextVisiNodeDefaultL1(DeciTreeOption<StorextInfo> option) {
		super(option, StorextInfo.class, StorextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorextInfo>> getTreeClassHook() {
		return StorextNodeDefaultL1.class;
	}
	
	
	
	@Override protected List<StorextInfo> toBaseClassHook(List<StorextInfo> baseInfos, List<StorextInfo> results) {
		return results;
	}
}
