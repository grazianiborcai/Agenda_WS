package br.com.mind5.business.refundPolicyStore.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.info.RefuporeMerger;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroup.model.decisionTree.RootRefugroupSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefuporeVisiMergeRefugroup extends ActionVisitorTemplateMerge<RefuporeInfo, RefugroupInfo> {
	
	public RefuporeVisiMergeRefugroup(DeciTreeOption<RefuporeInfo> option) {
		super(option, RefugroupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefugroupInfo>> getTreeClassHook() {
		return RootRefugroupSelect.class;
	}
	
	
	
	@Override protected List<RefuporeInfo> mergeHook(List<RefuporeInfo> baseInfos, List<RefugroupInfo> selectedInfos) {
		return RefuporeMerger.mergeWithRefugroup(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
