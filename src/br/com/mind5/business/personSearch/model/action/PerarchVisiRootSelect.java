package br.com.mind5.business.personSearch.model.action;

import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.decisionTree.PerarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerarchVisiRootSelect extends ActionVisitorTemplateAction<PerarchInfo, PerarchInfo> {

	public PerarchVisiRootSelect(DeciTreeOption<PerarchInfo> option) {
		super(option, PerarchInfo.class, PerarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PerarchInfo>> getTreeClassHook() {
		return PerarchRootSelect.class;
	}
	
	
	
	@Override protected List<PerarchInfo> toBaseClassHook(List<PerarchInfo> baseInfos, List<PerarchInfo> results) {
		return results;
	}
}
