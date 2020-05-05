package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.creditCardSearch.model.decisionTree.RootCrecarchSelect;

final class VisiCrecardMergeCrecarch extends ActionVisitorTemplateMergeV2<CrecardInfo, CrecarchInfo> {
	
	public VisiCrecardMergeCrecarch(DeciTreeOption<CrecardInfo> option) {
		super(option, CrecarchInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<CrecarchInfo>> getTreeClassHook() {
		return RootCrecarchSelect.class;
	}
	
	
	
	@Override protected List<CrecardInfo> mergeHook(List<CrecardInfo> baseInfos, List<CrecarchInfo> selectedInfos) {	
		return CrecardMerger.mergeWithCrecarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
