package br.com.mind5.business.refundPolicyStore.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.info.RefuporeMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefuporeVisiMergeToSelect extends ActionVisitorTemplateMerge<RefuporeInfo, RefuporeInfo> {
	
	public RefuporeVisiMergeToSelect(DeciTreeOption<RefuporeInfo> option) {
		super(option, RefuporeInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<RefuporeInfo>> getVisitorClassHook() {
		return RefuporeVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<RefuporeInfo> mergeHook(List<RefuporeInfo> baseInfos, List<RefuporeInfo> selectedInfos) {	
		return RefuporeMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
