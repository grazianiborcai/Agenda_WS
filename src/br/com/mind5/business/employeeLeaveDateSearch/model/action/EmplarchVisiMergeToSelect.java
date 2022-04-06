package br.com.mind5.business.employeeLeaveDateSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplarchVisiMergeToSelect extends ActionVisitorTemplateMerge<EmplarchInfo, EmplarchInfo> {
	
	public EmplarchVisiMergeToSelect(DeciTreeOption<EmplarchInfo> option) {
		super(option, EmplarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<EmplarchInfo>> getVisitorClassHook() {
		return EmplarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<EmplarchInfo> mergeHook(List<EmplarchInfo> baseInfos, List<EmplarchInfo> selectedInfos) {	
		return EmplarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
