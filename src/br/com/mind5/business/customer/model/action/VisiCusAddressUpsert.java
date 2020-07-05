package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.RootAddressUpsertdel;
import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusAddressUpsert extends ActionVisitorTemplateActionV2<CusInfo, AddressInfo> {
	
	public VisiCusAddressUpsert(DeciTreeOption<CusInfo> option) {
		super(option, CusInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return RootAddressUpsertdel.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<CusInfo> baseInfos) {
		return AddressCopier.copyFromCus(baseInfos);
	}
	
	
	
	@Override protected List<CusInfo> toBaseClassHook(List<CusInfo> baseInfos, List<AddressInfo> results) {
		return CusMerger.mergeWithAddress(baseInfos, results);
	}
}
