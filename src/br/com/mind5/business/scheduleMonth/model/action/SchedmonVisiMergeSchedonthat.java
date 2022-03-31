package br.com.mind5.business.scheduleMonth.model.action;

import java.util.List;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonth.info.SchedmonMerger;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatCopier;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.scheduleMonthData.model.decisionTree.RootSchedonthatSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedmonVisiMergeSchedonthat extends ActionVisitorTemplateMerge<SchedmonInfo, SchedonthatInfo> {
	
	public SchedmonVisiMergeSchedonthat(DeciTreeOption<SchedmonInfo> option) {
		super(option, SchedonthatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedonthatInfo>> getTreeClassHook() {
		return RootSchedonthatSelect.class;
	}
	
	
	
	@Override protected List<SchedonthatInfo> toActionClassHook(List<SchedmonInfo> recordInfos) {
		return SchedonthatCopier.copyFromSchedmon(recordInfos);
	}
	
	
	
	@Override protected List<SchedmonInfo> mergeHook(List<SchedmonInfo> baseInfos, List<SchedonthatInfo> selectedInfos) {	
		return SchedmonMerger.mergeWithSchedonthat(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
