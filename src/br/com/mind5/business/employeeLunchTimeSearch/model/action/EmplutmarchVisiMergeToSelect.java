package br.com.mind5.business.employeeLunchTimeSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeLunchTimeSearch.info.EmplutmarchInfo;
import br.com.mind5.business.employeeLunchTimeSearch.info.EmplutmarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmarchVisiMergeToSelect extends ActionVisitorTemplateMerge<EmplutmarchInfo, EmplutmarchInfo> {
	
	public EmplutmarchVisiMergeToSelect(DeciTreeOption<EmplutmarchInfo> option) {
		super(option, EmplutmarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<EmplutmarchInfo>> getVisitorClassHook() {
		return EmplutmarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<EmplutmarchInfo> mergeHook(List<EmplutmarchInfo> baseInfos, List<EmplutmarchInfo> selectedInfos) {	
		return EmplutmarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
