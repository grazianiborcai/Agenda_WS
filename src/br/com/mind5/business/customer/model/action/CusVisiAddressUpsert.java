package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.RootAddressUpsertdel;
import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusVisiAddressUpsert extends ActionVisitorTemplateAction<CusInfo, AddressInfo> {
	
	public CusVisiAddressUpsert(DeciTreeOption<CusInfo> option) {
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
