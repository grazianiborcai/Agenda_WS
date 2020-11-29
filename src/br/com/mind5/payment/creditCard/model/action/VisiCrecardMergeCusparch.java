package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.model.decisionTree.RootCusparchSelectUser;

final class VisiCrecardMergeCusparch extends ActionVisitorTemplateMerge<CrecardInfo, CusparchInfo> {
	
	public VisiCrecardMergeCusparch(DeciTreeOption<CrecardInfo> option) {
		super(option, CusparchInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusparchInfo>> getTreeClassHook() {
		return RootCusparchSelectUser.class;
	}
	
	
	
	@Override protected List<CrecardInfo> mergeHook(List<CrecardInfo> baseInfos, List<CusparchInfo> selectedInfos) {	
		return CrecardMerger.mergeWithCusparch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
