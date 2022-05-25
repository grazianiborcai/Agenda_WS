package br.com.mind5.business.storeManager.model.action;

import java.util.List;

import br.com.mind5.business.storeManager.info.StomanInfo;
import br.com.mind5.business.storeManager.model.decisionTree.StomanRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StomanVisiRootSelect extends ActionVisitorTemplateAction<StomanInfo, StomanInfo> {

	public StomanVisiRootSelect(DeciTreeOption<StomanInfo> option) {
		super(option, StomanInfo.class, StomanInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StomanInfo>> getTreeClassHook() {
		return StomanRootSelect.class;
	}
	
	
	
	@Override protected List<StomanInfo> toBaseClassHook(List<StomanInfo> baseInfos, List<StomanInfo> results) {
		return results;
	}
}
