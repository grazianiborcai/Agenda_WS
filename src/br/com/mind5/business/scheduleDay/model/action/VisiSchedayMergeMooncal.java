package br.com.mind5.business.scheduleDay.model.action;

import java.util.List;

import br.com.mind5.business.moonCalendar.info.MooncalCopier;
import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.business.moonCalendar.model.decisionTree.RootMooncalSelect;
import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDay.info.SchedayMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedayMergeMooncal extends ActionVisitorTemplateMergeV2<SchedayInfo, MooncalInfo> {
	
	public VisiSchedayMergeMooncal(DeciTreeOption<SchedayInfo> option) {
		super(option, MooncalInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MooncalInfo>> getTreeClassHook() {
		return RootMooncalSelect.class;
	}
	
	
	
	@Override protected List<MooncalInfo> toActionClassHook(List<SchedayInfo> recordInfos) {
		return MooncalCopier.copyFromScheday(recordInfos);
	}
	
	
	
	@Override protected List<SchedayInfo> mergeHook(List<SchedayInfo> baseInfos, List<MooncalInfo> selectedInfos) {	
		return SchedayMerger.mergeWithMooncal(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
