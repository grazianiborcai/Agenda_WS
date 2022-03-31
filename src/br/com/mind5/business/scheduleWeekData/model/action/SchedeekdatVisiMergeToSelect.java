package br.com.mind5.business.scheduleWeekData.model.action;

import java.util.List;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedeekdatVisiMergeToSelect extends ActionVisitorTemplateMerge<SchedeekdatInfo, SchedeekdatInfo> {
	
	public SchedeekdatVisiMergeToSelect(DeciTreeOption<SchedeekdatInfo> option) {
		super(option, SchedeekdatInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SchedeekdatInfo>> getVisitorClassHook() {
		return SchedeekdatVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedeekdatInfo> mergeHook(List<SchedeekdatInfo> baseInfos, List<SchedeekdatInfo> selectedInfos) {	
		return SchedeekdatMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
