package br.com.mind5.business.personLegal.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.AddressRootInsertLegalPerson;
import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.info.PeregMerger;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregVisiAddressInsert extends ActionVisitorTemplateAction<PeregInfo, AddressInfo> {
	
	public PeregVisiAddressInsert(DeciTreeOption<PeregInfo> option) {
		super(option, PeregInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return AddressRootInsertLegalPerson.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<PeregInfo> baseInfos) {
		return AddressCopier.copyFromPereg(baseInfos);
	}
	
	
	
	@Override protected List<PeregInfo> toBaseClassHook(List<PeregInfo> baseInfos, List<AddressInfo> results) {
		return PeregMerger.mergeWithAddress(baseInfos, results);
	}
}
