package br.com.mind5.business.address.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressMerger;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.decisionTree.AddresnapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddressVisiAddresnapInsert extends ActionVisitorTemplateAction<AddressInfo, AddresnapInfo> {

	public AddressVisiAddresnapInsert(DeciTreeOption<AddressInfo> option) {
		super(option, AddressInfo.class, AddresnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddresnapInfo>> getTreeClassHook() {
		return AddresnapRootInsert.class;
	}
	
	
	
	@Override protected List<AddressInfo> toBaseClassHook(List<AddressInfo> baseInfos, List<AddresnapInfo> results) {
		return AddressMerger.mergeWithAddresnap(baseInfos, results);
	}
}
