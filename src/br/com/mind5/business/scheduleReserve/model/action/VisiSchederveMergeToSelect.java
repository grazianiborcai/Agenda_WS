package br.com.mind5.business.scheduleReserve.model.action;

import java.util.List;

import br.com.mind5.business.scheduleReserve.info.SchederveInfo;
import br.com.mind5.business.scheduleReserve.info.SchederveMerger;
import br.com.mind5.model.action.ActionStd;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchederveMergeToSelect extends ActionVisitorTemplateMerge<SchederveInfo, SchederveInfo> {
	
	public VisiSchederveMergeToSelect(DeciTreeOption<SchederveInfo> option) {
		super(option, SchederveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SchederveInfo>> getActionClassHook() {
		return StdSchederveDaoSelect.class;
	}
	
	
	
	@Override protected List<SchederveInfo> mergeHook(List<SchederveInfo> baseInfos, List<SchederveInfo> selectedInfos) {	
		return SchederveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
