package br.com.mind5.business.addressDefault.model.action;

import java.util.List;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.business.addressDefault.model.decisionTree.AddaultRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddaultVisiRootSelect extends ActionVisitorTemplateAction<AddaultInfo, AddaultInfo> {

	public AddaultVisiRootSelect(DeciTreeOption<AddaultInfo> option) {
		super(option, AddaultInfo.class, AddaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddaultInfo>> getTreeClassHook() {
		return AddaultRootSelect.class;
	}
	
	
	
	@Override protected List<AddaultInfo> toBaseClassHook(List<AddaultInfo> baseInfos, List<AddaultInfo> results) {
		return results;
	}
}
