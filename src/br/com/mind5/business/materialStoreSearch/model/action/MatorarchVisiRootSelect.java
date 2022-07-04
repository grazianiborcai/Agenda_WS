package br.com.mind5.business.materialStoreSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.business.materialStoreSearch.model.decisionTree.MatorarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatorarchVisiRootSelect extends ActionVisitorTemplateAction<MatorarchInfo, MatorarchInfo> {

	public MatorarchVisiRootSelect(DeciTreeOption<MatorarchInfo> option) {
		super(option, MatorarchInfo.class, MatorarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatorarchInfo>> getTreeClassHook() {
		return MatorarchRootSelect.class;
	}
	
	
	
	@Override protected List<MatorarchInfo> toBaseClassHook(List<MatorarchInfo> baseInfos, List<MatorarchInfo> results) {
		return results;
	}
}
