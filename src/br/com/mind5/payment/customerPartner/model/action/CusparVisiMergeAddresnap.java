package br.com.mind5.payment.customerPartner.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapCopier;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.decisionTree.AddresnapRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.info.CusparMerger;

public final class CusparVisiMergeAddresnap extends ActionVisitorTemplateMerge<CusparInfo, AddresnapInfo> {
	
	public CusparVisiMergeAddresnap(DeciTreeOption<CusparInfo> option) {
		super(option, AddresnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddresnapInfo>> getTreeClassHook() {
		return AddresnapRootSearch.class;
	}
	
	
	
	@Override protected List<AddresnapInfo> toActionClassHook(List<CusparInfo> baseInfos) {
		return AddresnapCopier.copyFromCuspar(baseInfos);	
	}
	
	
	
	@Override protected List<CusparInfo> mergeHook(List<CusparInfo> baseInfos, List<AddresnapInfo> selectedInfos) {	
		return CusparMerger.mergeWithAddresnap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
