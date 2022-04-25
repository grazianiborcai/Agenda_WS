package br.com.mind5.business.employeeLunchTime.model.action;

import java.util.List;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.info.EmplutmMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmVisiMergeToDelete extends ActionVisitorTemplateMerge<EmplutmInfo, EmplutmInfo> {
	
	public EmplutmVisiMergeToDelete(DeciTreeOption<EmplutmInfo> option) {
		super(option, EmplutmInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<EmplutmInfo>> getVisitorClassHook() {
		return EmplutmVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<EmplutmInfo> mergeHook(List<EmplutmInfo> baseInfos, List<EmplutmInfo> selectedInfos) {	
		return EmplutmMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
