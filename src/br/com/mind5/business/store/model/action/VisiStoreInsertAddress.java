package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.RootAddressInsert;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoreInsertAddress extends ActionVisitorTemplateActionV2<StoreInfo, AddressInfo> {
	
	public VisiStoreInsertAddress(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return RootAddressInsert.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<StoreInfo> recordInfos) {		
		return AddressCopier.copyFromStore(recordInfos);
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<AddressInfo> results) {
		return StoreMerger.mergeWithAddress(baseInfos, results);	
	}
}
