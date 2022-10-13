package br.com.mind5.business.personLegal.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.AddressRootUpdateLegalPerson;
import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.info.PeregMerger;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregVisiAddressUpdate extends ActionVisitorTemplateAction<PeregInfo, AddressInfo> {
	
	public PeregVisiAddressUpdate(DeciTreeOption<PeregInfo> option) {
		super(option, PeregInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return AddressRootUpdateLegalPerson.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<PeregInfo> baseInfos) {
		return AddressCopier.copyFromPereg(baseInfos);
	}
	
	
	
	@Override protected List<PeregInfo> toBaseClassHook(List<PeregInfo> baseInfos, List<AddressInfo> results) {
		return PeregMerger.mergeWithAddress(baseInfos, results);
	}
}
