package br.com.mind5.business.scheduleDay.model.action;

import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDay.info.SchedayMerger;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatCopier;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.scheduleMonthData.model.decisionTree.RootSchedonthatSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedayMergeSchedonthat extends ActionVisitorTemplateMergeV2<SchedayInfo, SchedonthatInfo> {
	
	public VisiSchedayMergeSchedonthat(DeciTreeOption<SchedayInfo> option) {
		super(option, SchedonthatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedonthatInfo>> getTreeClassHook() {
		return RootSchedonthatSelect.class;
	}
	
	
	
	@Override protected List<SchedonthatInfo> toActionClassHook(List<SchedayInfo> recordInfos) {
		return SchedonthatCopier.copyFromSchedmon(recordInfos);
	}
	
	
	
	@Override protected List<SchedayInfo> mergeHook(List<SchedayInfo> baseInfos, List<SchedonthatInfo> selectedInfos) {	
		return SchedayMerger.mergeWithSchedonthat(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
