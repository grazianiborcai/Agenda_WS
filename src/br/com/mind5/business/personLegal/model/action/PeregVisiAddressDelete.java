package br.com.mind5.business.personLegal.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.AddressRootDelete;
import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregVisiAddressDelete extends ActionVisitorTemplateAction<PeregInfo, AddressInfo> {
	
	public PeregVisiAddressDelete(DeciTreeOption<PeregInfo> option) {
		super(option, PeregInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return AddressRootDelete.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<PeregInfo> recordInfos) {
		return AddressCopier.copyFromPereg(recordInfos);
	}
	
	
	
	@Override protected List<PeregInfo> toBaseClassHook(List<PeregInfo> baseInfos, List<AddressInfo> results) {
		return baseInfos;
	}
}
