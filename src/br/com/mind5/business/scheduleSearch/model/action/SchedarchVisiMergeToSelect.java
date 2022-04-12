package br.com.mind5.business.scheduleSearch.model.action;

import java.util.List;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.business.scheduleSearch.info.SchedarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedarchVisiMergeToSelect extends ActionVisitorTemplateMerge<SchedarchInfo, SchedarchInfo> {
	
	public SchedarchVisiMergeToSelect(DeciTreeOption<SchedarchInfo> option) {
		super(option, SchedarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SchedarchInfo>> getVisitorClassHook() {
		return SchedarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedarchInfo> mergeHook(List<SchedarchInfo> baseInfos, List<SchedarchInfo> selectedInfos) {	
		return SchedarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
