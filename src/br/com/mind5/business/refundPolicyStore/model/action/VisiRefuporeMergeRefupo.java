package br.com.mind5.business.refundPolicyStore.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.info.RefuporeMerger;
import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;
import br.com.mind5.masterData.refundPolicy.model.decisionTree.RootRefupoSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefuporeMergeRefupo extends ActionVisitorTemplateMergeV2<RefuporeInfo, RefupoInfo> {
	
	public VisiRefuporeMergeRefupo(DeciTreeOption<RefuporeInfo> option) {
		super(option, RefupoInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefupoInfo>> getTreeClassHook() {
		return RootRefupoSelect.class;
	}
	
	
	
	@Override protected List<RefuporeInfo> mergeHook(List<RefuporeInfo> baseInfos, List<RefupoInfo> selectedInfos) {
		return RefuporeMerger.mergeWithRefupo(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
