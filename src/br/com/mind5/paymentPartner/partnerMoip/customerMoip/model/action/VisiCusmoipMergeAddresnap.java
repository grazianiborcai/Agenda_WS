package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapCopier;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.decisionTree.AddresnapRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipMerger;

final class VisiCusmoipMergeAddresnap extends ActionVisitorTemplateMerge<CusmoipInfo, AddresnapInfo> {
	
	public VisiCusmoipMergeAddresnap(DeciTreeOption<CusmoipInfo> option) {
		super(option, AddresnapInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddresnapInfo>> getTreeClassHook() {
		return AddresnapRootSelect.class;
	}
	
	
	
	@Override protected List<AddresnapInfo> toActionClassHook(List<CusmoipInfo> baseInfos) {
		return AddresnapCopier.copyFromCusmoip(baseInfos);	
	}
	
	
	
	@Override protected List<CusmoipInfo> mergeHook(List<CusmoipInfo> baseInfos, List<AddresnapInfo> selectedInfos) {	
		return CusmoipMerger.mergeWithAddresnap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
