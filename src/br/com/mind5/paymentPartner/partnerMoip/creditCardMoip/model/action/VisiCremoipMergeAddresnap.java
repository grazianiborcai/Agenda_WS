package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapCopier;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.decisionTree.RootAddresnapSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipMerger;

final class VisiCremoipMergeAddresnap extends ActionVisitorTemplateMerge<CremoipInfo, AddresnapInfo> {
	
	public VisiCremoipMergeAddresnap(DeciTreeOption<CremoipInfo> option) {
		super(option, AddresnapInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddresnapInfo>> getTreeClassHook() {
		return RootAddresnapSelect.class;
	}
	
	
	
	@Override protected List<AddresnapInfo> toActionClassHook(List<CremoipInfo> baseInfos) {
		return AddresnapCopier.copyFromCremoip(baseInfos);	
	}
	
	
	
	@Override protected List<CremoipInfo> mergeHook(List<CremoipInfo> baseInfos, List<AddresnapInfo> selectedInfos) {	
		return CremoipMerger.mergeWithAddresnap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
