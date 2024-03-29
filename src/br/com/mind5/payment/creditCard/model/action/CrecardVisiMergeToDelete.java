package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;
import br.com.mind5.payment.creditCard.model.decisionTree.CrecardRootSelectAuth;

public final class CrecardVisiMergeToDelete extends ActionVisitorTemplateMerge<CrecardInfo, CrecardInfo> {
	
	public CrecardVisiMergeToDelete(DeciTreeOption<CrecardInfo> option) {
		super(option, CrecardInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<CrecardInfo>> getTreeClassHook() {
		return CrecardRootSelectAuth.class;
	}
	
	
	
	@Override protected List<CrecardInfo> mergeHook(List<CrecardInfo> baseInfos, List<CrecardInfo> selectedInfos) {	
		return CrecardMerger.mergeToDelete( baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
