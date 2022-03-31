package br.com.mind5.business.storeText.model.action;

import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.decisionTree.StorextNodeDeleteL1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextVisiNodeDeleteL1 extends ActionVisitorTemplateAction<StorextInfo, StorextInfo> {

	public StorextVisiNodeDeleteL1(DeciTreeOption<StorextInfo> option) {
		super(option, StorextInfo.class, StorextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorextInfo>> getTreeClassHook() {
		return StorextNodeDeleteL1.class;
	}
	
	
	
	@Override protected List<StorextInfo> toBaseClassHook(List<StorextInfo> baseInfos, List<StorextInfo> results) {
		return results;
	}
}
