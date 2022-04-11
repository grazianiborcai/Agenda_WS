package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnerVisiMergeToDelete extends ActionVisitorTemplateMerge<OwnerInfo, OwnerInfo> {
	
	public OwnerVisiMergeToDelete(DeciTreeOption<OwnerInfo> option) {
		super(option, OwnerInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<OwnerInfo>> getVisitorClassHook() {
		return OwnerVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<OwnerInfo> mergeHook(List<OwnerInfo> baseInfos, List<OwnerInfo> selectedInfos) {	
		return OwnerMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
