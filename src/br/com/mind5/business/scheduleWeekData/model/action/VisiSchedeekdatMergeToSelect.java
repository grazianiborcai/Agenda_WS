package br.com.mind5.business.scheduleWeekData.model.action;

import java.util.List;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedeekdatMergeToSelect extends ActionVisitorTemplateMergeV2<SchedeekdatInfo, SchedeekdatInfo> {
	
	public VisiSchedeekdatMergeToSelect(DeciTreeOption<SchedeekdatInfo> option) {
		super(option, SchedeekdatInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<SchedeekdatInfo>> getActionClassHook() {
		return StdSchedeekdatDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedeekdatInfo> mergeHook(List<SchedeekdatInfo> baseInfos, List<SchedeekdatInfo> selectedInfos) {	
		return SchedeekdatMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
