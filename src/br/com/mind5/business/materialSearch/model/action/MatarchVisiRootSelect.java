package br.com.mind5.business.materialSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.decisionTree.MatarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatarchVisiRootSelect extends ActionVisitorTemplateAction<MatarchInfo, MatarchInfo> {

	public MatarchVisiRootSelect(DeciTreeOption<MatarchInfo> option) {
		super(option, MatarchInfo.class, MatarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatarchInfo>> getTreeClassHook() {
		return MatarchRootSelect.class;
	}
	
	
	
	@Override protected List<MatarchInfo> toBaseClassHook(List<MatarchInfo> baseInfos, List<MatarchInfo> results) {
		return results;
	}
}
