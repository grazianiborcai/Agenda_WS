package br.com.mind5.business.scheduleMonthData.model.action;

import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedonthatVisiMergeToSelect extends ActionVisitorTemplateMerge<SchedonthatInfo, SchedonthatInfo> {
	
	public SchedonthatVisiMergeToSelect(DeciTreeOption<SchedonthatInfo> option) {
		super(option, SchedonthatInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SchedonthatInfo>> getVisitorClassHook() {
		return SchedonthatVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedonthatInfo> mergeHook(List<SchedonthatInfo> baseInfos, List<SchedonthatInfo> selectedInfos) {	
		return SchedonthatMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
