package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.business.phone.info.PhoneCopier;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.PhoneRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;

public final class CrecardVisiMergePhone extends ActionVisitorTemplateMerge<CrecardInfo, PhoneInfo> {
	
	public CrecardVisiMergePhone(DeciTreeOption<CrecardInfo> option) {
		super(option, PhoneInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return PhoneRootSearch.class;
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<CrecardInfo> baseInfos) {
		return PhoneCopier.copyFromCrecard(baseInfos);	
	}
	
	
	
	@Override protected List<CrecardInfo> mergeHook(List<CrecardInfo> baseInfos, List<PhoneInfo> selectedInfos) {	
		return CrecardMerger.mergeWithPhone(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
