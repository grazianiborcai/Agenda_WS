package br.com.mind5.business.scheduleMonth.model.action;

import java.util.List;

import br.com.mind5.business.moonCalendar.info.MooncalCopier;
import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.business.moonCalendar.model.decisionTree.RootMooncalSelect;
import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonth.info.SchedmonMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedmonMergeMooncal extends ActionVisitorTemplateMergeV2<SchedmonInfo, MooncalInfo> {
	
	public VisiSchedmonMergeMooncal(DeciTreeOption<SchedmonInfo> option) {
		super(option, MooncalInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MooncalInfo>> getTreeClassHook() {
		return RootMooncalSelect.class;
	}
	
	
	
	@Override protected List<MooncalInfo> toActionClassHook(List<SchedmonInfo> recordInfos) {
		return MooncalCopier.copyFromSchedmon(recordInfos);
	}
	
	
	
	@Override protected List<SchedmonInfo> mergeHook(List<SchedmonInfo> baseInfos, List<MooncalInfo> selectedInfos) {	
		return SchedmonMerger.mergeWithMooncal(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
