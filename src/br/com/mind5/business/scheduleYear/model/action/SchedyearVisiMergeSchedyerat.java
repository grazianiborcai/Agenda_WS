package br.com.mind5.business.scheduleYear.model.action;

import java.util.List;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.info.SchedyearMerger;
import br.com.mind5.business.scheduleYearData.info.SchedyeratCopier;
import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.business.scheduleYearData.model.decisionTree.RootSchedyeratSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedyearVisiMergeSchedyerat extends ActionVisitorTemplateMerge<SchedyearInfo, SchedyeratInfo> {
	
	public SchedyearVisiMergeSchedyerat(DeciTreeOption<SchedyearInfo> option) {
		super(option, SchedyeratInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedyeratInfo>> getTreeClassHook() {
		return RootSchedyeratSelect.class;
	}
	
	
	
	@Override protected List<SchedyeratInfo> toActionClassHook(List<SchedyearInfo> baseInfos) {
		return SchedyeratCopier.copyFromSchedyear(baseInfos);
	}
	
	
	
	@Override protected List<SchedyearInfo> mergeHook(List<SchedyearInfo> baseInfos, List<SchedyeratInfo> selectedInfos) {	
		return SchedyearMerger.mergeWithSchedyerat(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
