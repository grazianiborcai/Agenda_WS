package br.com.mind5.business.storeLeaveDate.model.action;

import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.info.StolateMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolateVisiMergeToUpdate extends ActionVisitorTemplateMerge<StolateInfo, StolateInfo> {
	
	public StolateVisiMergeToUpdate(DeciTreeOption<StolateInfo> option) {
		super(option, StolateInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StolateInfo>> getVisitorClassHook() {
		return StolateVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StolateInfo> mergeHook(List<StolateInfo> baseInfos, List<StolateInfo> selectedInfos) {	
		return StolateMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
