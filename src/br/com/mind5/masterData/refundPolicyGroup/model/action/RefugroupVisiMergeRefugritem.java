package br.com.mind5.masterData.refundPolicyGroup.model.action;

import java.util.List;

import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupMerger;
import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;
import br.com.mind5.masterData.refundPolicyGroupItem.model.decisionTree.RefugritemRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefugroupVisiMergeRefugritem extends ActionVisitorTemplateMerge<RefugroupInfo, RefugritemInfo> {
	
	public RefugroupVisiMergeRefugritem(DeciTreeOption<RefugroupInfo> option) {
		super(option, RefugritemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefugritemInfo>> getTreeClassHook() {
		return RefugritemRootSearch.class;
	}
	
	
	
	@Override protected List<RefugroupInfo> mergeHook(List<RefugroupInfo> baseInfos, List<RefugritemInfo> selectedInfos) {
		return RefugroupMerger.mergeWithRefugritem(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
