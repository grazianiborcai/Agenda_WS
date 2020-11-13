package br.com.mind5.payment.customerPartner.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.RootAddressSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.info.CusparMerger;

final class VisiCusparMergeAddress extends ActionVisitorTemplateMerge<CusparInfo, AddressInfo> {
	
	public VisiCusparMergeAddress(DeciTreeOption<CusparInfo> option) {
		super(option, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return RootAddressSearch.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<CusparInfo> baseInfos) {
		return AddressCopier.copyFromCuspar(baseInfos);	
	}
	
	
	
	@Override protected List<CusparInfo> mergeHook(List<CusparInfo> baseInfos, List<AddressInfo> selectedInfos) {	
		return CusparMerger.mergeWithAddress(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
