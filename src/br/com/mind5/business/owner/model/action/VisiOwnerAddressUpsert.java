package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.RootAddressUpsertdel;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerAddressUpsert extends ActionVisitorTemplateActionV2<OwnerInfo, AddressInfo> {
	
	public VisiOwnerAddressUpsert(DeciTreeOption<OwnerInfo> option) {
		super(option, OwnerInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return RootAddressUpsertdel.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		return AddressCopier.copyFromOwner(recordInfos);
	}
}
