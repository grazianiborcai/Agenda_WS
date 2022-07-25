package br.com.mind5.discount.discountStoreSearch.model.action;

import java.util.List;

import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;
import br.com.mind5.discount.discountStoreSearch.model.decisionTree.DisorarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisorarchVisiRootSelect extends ActionVisitorTemplateAction<DisorarchInfo, DisorarchInfo> {

	public DisorarchVisiRootSelect(DeciTreeOption<DisorarchInfo> option) {
		super(option, DisorarchInfo.class, DisorarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<DisorarchInfo>> getTreeClassHook() {
		return DisorarchRootSelect.class;
	}
	
	
	
	@Override protected List<DisorarchInfo> toBaseClassHook(List<DisorarchInfo> baseInfos, List<DisorarchInfo> results) {
		return results;
	}
}
