package br.com.mind5.business.employeeLunchTimeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.employeeLunchTimeSnapshot.info.EmplutmapInfo;
import br.com.mind5.business.employeeLunchTimeSnapshot.info.EmplutmapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmapVisiMergeToSelect extends ActionVisitorTemplateMerge<EmplutmapInfo, EmplutmapInfo> {
	
	public EmplutmapVisiMergeToSelect(DeciTreeOption<EmplutmapInfo> option) {
		super(option, EmplutmapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<EmplutmapInfo>> getVisitorClassHook() {
		return EmplutmapVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<EmplutmapInfo> mergeHook(List<EmplutmapInfo> baseInfos, List<EmplutmapInfo> selectedInfos) {	
		return EmplutmapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
