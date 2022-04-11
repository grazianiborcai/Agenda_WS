package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.AddressRootUpsertdel;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnerVisiAddressUpsert extends ActionVisitorTemplateAction<OwnerInfo, AddressInfo> {
	
	public OwnerVisiAddressUpsert(DeciTreeOption<OwnerInfo> option) {
		super(option, OwnerInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return AddressRootUpsertdel.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		return AddressCopier.copyFromOwner(recordInfos);
	}
}
