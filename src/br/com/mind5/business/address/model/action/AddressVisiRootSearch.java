package br.com.mind5.business.address.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.AddressRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddressVisiRootSearch extends ActionVisitorTemplateAction<AddressInfo, AddressInfo> {

	public AddressVisiRootSearch(DeciTreeOption<AddressInfo> option) {
		super(option, AddressInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return AddressRootSearch.class;
	}
	
	
	
	@Override protected List<AddressInfo> toBaseClassHook(List<AddressInfo> baseInfos, List<AddressInfo> results) {
		return results;
	}
}
