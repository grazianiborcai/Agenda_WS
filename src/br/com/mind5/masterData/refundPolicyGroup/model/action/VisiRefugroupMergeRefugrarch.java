package br.com.mind5.masterData.refundPolicyGroup.model.action;

import java.util.List;

import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupMerger;
import br.com.mind5.masterData.refundPolicyGroupSearch.info.RefugrarchInfo;
import br.com.mind5.masterData.refundPolicyGroupSearch.model.decisionTree.RootRefugrarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefugroupMergeRefugrarch extends ActionVisitorTemplateMergeV2<RefugroupInfo, RefugrarchInfo> {
	
	public VisiRefugroupMergeRefugrarch(DeciTreeOption<RefugroupInfo> option) {
		super(option, RefugrarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefugrarchInfo>> getTreeClassHook() {
		return RootRefugrarchSelect.class;
	}
	
	
	
	@Override protected List<RefugroupInfo> mergeHook(List<RefugroupInfo> baseInfos, List<RefugrarchInfo> selectedInfos) {
		return RefugroupMerger.mergeWithRefugrarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}