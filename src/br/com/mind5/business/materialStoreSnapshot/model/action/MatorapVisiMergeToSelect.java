package br.com.mind5.business.materialStoreSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.business.materialStoreSnapshot.info.MatorapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatorapVisiMergeToSelect extends ActionVisitorTemplateMerge<MatorapInfo, MatorapInfo> {
	
	public MatorapVisiMergeToSelect(DeciTreeOption<MatorapInfo> option) {
		super(option, MatorapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<MatorapInfo>> getVisitorClassHook() {
		return MatorapVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<MatorapInfo> mergeHook(List<MatorapInfo> baseInfos, List<MatorapInfo> selectedInfos) {	
		return MatorapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
