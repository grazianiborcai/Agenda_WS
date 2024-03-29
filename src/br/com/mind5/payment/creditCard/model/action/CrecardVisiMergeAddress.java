package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.AddressRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;

public final class CrecardVisiMergeAddress extends ActionVisitorTemplateMerge<CrecardInfo, AddressInfo> {
	
	public CrecardVisiMergeAddress(DeciTreeOption<CrecardInfo> option) {
		super(option, AddressInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return AddressRootSelect.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<CrecardInfo> baseInfos) {
		return AddressCopier.copyFromCrecard(baseInfos);	
	}
	
	
	
	@Override protected List<CrecardInfo> mergeHook(List<CrecardInfo> baseInfos, List<AddressInfo> selectedInfos) {	
		return CrecardMerger.mergeWithAddress(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
