package br.com.mind5.business.refundPolicy.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.business.refundPolicy.info.RefupolMerger;
import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.decisionTree.RefuporeRootSelectFallback;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefupolVisiMergeRefupore extends ActionVisitorTemplateMerge<RefupolInfo, RefuporeInfo> {
	
	public RefupolVisiMergeRefupore(DeciTreeOption<RefupolInfo> option) {
		super(option, RefuporeInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefuporeInfo>> getTreeClassHook() {
		return RefuporeRootSelectFallback.class;
	}
	
	
	
	@Override protected List<RefupolInfo> mergeHook(List<RefupolInfo> baseInfos, List<RefuporeInfo> selectedInfos) {	
		return RefupolMerger.mergeWithRefupore(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
