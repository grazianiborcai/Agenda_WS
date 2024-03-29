package br.com.mind5.business.scheduleYearData.model.action;

import java.util.List;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.business.scheduleYearData.info.SchedyeratMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedyeratVisiMergeToSelect extends ActionVisitorTemplateMerge<SchedyeratInfo, SchedyeratInfo> {
	
	public SchedyeratVisiMergeToSelect(DeciTreeOption<SchedyeratInfo> option) {
		super(option, SchedyeratInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SchedyeratInfo>> getVisitorClassHook() {
		return SchedyeratVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedyeratInfo> mergeHook(List<SchedyeratInfo> baseInfos, List<SchedyeratInfo> selectedInfos) {	
		return SchedyeratMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
