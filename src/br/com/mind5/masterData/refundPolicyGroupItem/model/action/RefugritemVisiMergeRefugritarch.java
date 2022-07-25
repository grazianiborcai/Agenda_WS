package br.com.mind5.masterData.refundPolicyGroupItem.model.action;

import java.util.List;

import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;
import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemMerger;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.model.decisionTree.RootRefugritarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefugritemVisiMergeRefugritarch extends ActionVisitorTemplateMerge<RefugritemInfo, RefugritarchInfo> {
	
	public RefugritemVisiMergeRefugritarch(DeciTreeOption<RefugritemInfo> option) {
		super(option, RefugritarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefugritarchInfo>> getTreeClassHook() {
		return RootRefugritarchSelect.class;
	}
	
	
	
	@Override protected List<RefugritemInfo> mergeHook(List<RefugritemInfo> baseInfos, List<RefugritarchInfo> selectedInfos) {
		return RefugritemMerger.mergeWithRefugritarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
