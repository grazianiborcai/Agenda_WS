package br.com.mind5.business.orderItemSearch.model.action;

import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSearch.model.decisionTree.OrdemarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdemarchVisiRootSelect extends ActionVisitorTemplateAction<OrdemarchInfo, OrdemarchInfo> {

	public OrdemarchVisiRootSelect(DeciTreeOption<OrdemarchInfo> option) {
		super(option, OrdemarchInfo.class, OrdemarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdemarchInfo>> getTreeClassHook() {
		return OrdemarchRootSelect.class;
	}
	
	
	
	@Override protected List<OrdemarchInfo> toBaseClassHook(List<OrdemarchInfo> baseInfos, List<OrdemarchInfo> results) {
		return results;
	}
}
