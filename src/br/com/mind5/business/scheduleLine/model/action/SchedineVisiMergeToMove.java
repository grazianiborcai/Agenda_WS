package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineVisiMergeToMove extends ActionVisitorTemplateMerge<SchedineInfo, SchedineInfo> {
	
	public SchedineVisiMergeToMove(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedineInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SchedineInfo>> getVisitorClassHook() {
		return SchedineVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> baseInfos, List<SchedineInfo> selectedInfos) {	
		return SchedineMerger.mergeToMove(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
