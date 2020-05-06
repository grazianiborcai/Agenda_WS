package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchCopier;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.model.decisionTree.RootCusparchSelect;

final class VisiCrecardMergeCusparch extends ActionVisitorTemplateMergeV2<CrecardInfo, CusparchInfo> {
	
	public VisiCrecardMergeCusparch(DeciTreeOption<CrecardInfo> option) {
		super(option, CusparchInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusparchInfo>> getTreeClassHook() {
		return RootCusparchSelect.class;
	}
	
	
	
	@Override protected List<CusparchInfo> toActionClassHook(List<CrecardInfo> baseInfos) {
		return CusparchCopier.copyFromCrecard(baseInfos);
	}
	
	
	
	@Override protected List<CrecardInfo> mergeHook(List<CrecardInfo> baseInfos, List<CusparchInfo> selectedInfos) {	
		return CrecardMerger.mergeWithCusparch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
