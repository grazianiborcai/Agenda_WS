package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.RootAddressDelete;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiAddressDelete extends ActionVisitorTemplateAction<StoreInfo, AddressInfo> {
	
	public StoreVisiAddressDelete(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return RootAddressDelete.class;
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<AddressInfo> results) {
		return baseInfos;
	}
}
