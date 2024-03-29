package br.com.mind5.masterData.refundPolicyGroupItem.model.action;

import java.util.List;

import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;
import br.com.mind5.masterData.refundPolicy.model.decisionTree.RefupoRootSelect;
import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;
import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefugritemVisiMergeRefupo extends ActionVisitorTemplateMerge<RefugritemInfo, RefupoInfo> {
	
	public RefugritemVisiMergeRefupo(DeciTreeOption<RefugritemInfo> option) {
		super(option, RefupoInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefupoInfo>> getTreeClassHook() {
		return RefupoRootSelect.class;
	}
	
	
	
	@Override protected List<RefugritemInfo> mergeHook(List<RefugritemInfo> baseInfos, List<RefupoInfo> selectedInfos) {
		return RefugritemMerger.mergeWithRefupo(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
