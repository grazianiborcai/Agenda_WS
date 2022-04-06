package br.com.mind5.business.employeeLeaveDateRange.model.action;

import java.util.List;

import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplargVisiMergeToSelect extends ActionVisitorTemplateMerge<EmplargInfo, EmplargInfo> {
	
	public EmplargVisiMergeToSelect(DeciTreeOption<EmplargInfo> option) {
		super(option, EmplargInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<EmplargInfo>> getVisitorClassHook() {
		return EmplargVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<EmplargInfo> mergeHook(List<EmplargInfo> baseInfos, List<EmplargInfo> selectedInfos) {	
		return EmplargMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
