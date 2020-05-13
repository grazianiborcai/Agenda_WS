package br.com.mind5.business.scheduleReserve.model.action;

import java.util.List;

import br.com.mind5.business.scheduleReserve.info.SchederveInfo;
import br.com.mind5.business.scheduleReserve.info.SchederveMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchederveMergeToSelect extends ActionVisitorTemplateMergeV2<SchederveInfo, SchederveInfo> {
	
	public VisiSchederveMergeToSelect(DeciTreeOption<SchederveInfo> option) {
		super(option, SchederveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<SchederveInfo>> getActionClassHook() {
		return StdSchederveDaoSelect.class;
	}
	
	
	
	@Override protected List<SchederveInfo> mergeHook(List<SchederveInfo> baseInfos, List<SchederveInfo> selectedInfos) {	
		return SchederveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
