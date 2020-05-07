package br.com.mind5.masterData.refundPolicyGroup.model.action;

import java.util.List;

import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupMerger;
import br.com.mind5.masterData.refundPolicyGroupHeader.info.RefugraderInfo;
import br.com.mind5.masterData.refundPolicyGroupHeader.model.decisionTree.RootRefugraderSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefugroupMergeRefugrader extends ActionVisitorTemplateMergeV2<RefugroupInfo, RefugraderInfo> {
	
	public VisiRefugroupMergeRefugrader(DeciTreeOption<RefugroupInfo> option) {
		super(option, RefugraderInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefugraderInfo>> getTreeClassHook() {
		return RootRefugraderSelect.class;
	}
	
	
	
	@Override protected List<RefugroupInfo> mergeHook(List<RefugroupInfo> baseInfos, List<RefugraderInfo> selectedInfos) {
		return RefugroupMerger.mergeWithRefugrader(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
