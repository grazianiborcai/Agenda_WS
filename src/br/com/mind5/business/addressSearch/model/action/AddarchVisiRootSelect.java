package br.com.mind5.business.addressSearch.model.action;

import java.util.List;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.model.decisionTree.AddarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddarchVisiRootSelect extends ActionVisitorTemplateAction<AddarchInfo, AddarchInfo> {

	public AddarchVisiRootSelect(DeciTreeOption<AddarchInfo> option) {
		super(option, AddarchInfo.class, AddarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddarchInfo>> getTreeClassHook() {
		return AddarchRootSelect.class;
	}
	
	
	
	@Override protected List<AddarchInfo> toBaseClassHook(List<AddarchInfo> baseInfos, List<AddarchInfo> results) {
		return results;
	}
}
