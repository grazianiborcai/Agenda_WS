package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapCopier;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.decisionTree.AddresnapRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;

public final class CrecardVisiMergeAddresnap extends ActionVisitorTemplateMerge<CrecardInfo, AddresnapInfo> {
	
	public CrecardVisiMergeAddresnap(DeciTreeOption<CrecardInfo> option) {
		super(option, AddresnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddresnapInfo>> getTreeClassHook() {
		return AddresnapRootSearch.class;
	}
	
	
	
	@Override protected List<AddresnapInfo> toActionClassHook(List<CrecardInfo> baseInfos) {
		return AddresnapCopier.copyFromCrecard(baseInfos);	
	}
	
	
	
	@Override protected List<CrecardInfo> mergeHook(List<CrecardInfo> baseInfos, List<AddresnapInfo> selectedInfos) {	
		return CrecardMerger.mergeWithAddresnap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
