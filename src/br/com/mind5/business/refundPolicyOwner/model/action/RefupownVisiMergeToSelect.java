package br.com.mind5.business.refundPolicyOwner.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.info.RefupownMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefupownVisiMergeToSelect extends ActionVisitorTemplateMerge<RefupownInfo, RefupownInfo> {
	
	public RefupownVisiMergeToSelect(DeciTreeOption<RefupownInfo> option) {
		super(option, RefupownInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<RefupownInfo>> getVisitorClassHook() {
		return RefupownVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<RefupownInfo> mergeHook(List<RefupownInfo> baseInfos, List<RefupownInfo> selectedInfos) {	
		return RefupownMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
