package br.com.mind5.payment.customerPartner.model.action;

import java.util.List;

import br.com.mind5.business.phone.info.PhoneCopier;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.PhoneRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.info.CusparMerger;

final class VisiCusparMergePhone extends ActionVisitorTemplateMerge<CusparInfo, PhoneInfo> {
	
	public VisiCusparMergePhone(DeciTreeOption<CusparInfo> option) {
		super(option, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return PhoneRootSearch.class;
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<CusparInfo> baseInfos) {
		return PhoneCopier.copyFromCuspar(baseInfos);	
	}
	
	
	
	@Override protected List<CusparInfo> mergeHook(List<CusparInfo> baseInfos, List<PhoneInfo> selectedInfos) {	
		return CusparMerger.mergeWithPhone(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
