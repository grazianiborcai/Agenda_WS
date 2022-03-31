package br.com.mind5.business.scheduleDayData.model.action;

import java.util.List;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.business.scheduleDayData.info.SchedaytaMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedaytaVisiMergeToSelect extends ActionVisitorTemplateMerge<SchedaytaInfo, SchedaytaInfo> {
	
	public SchedaytaVisiMergeToSelect(DeciTreeOption<SchedaytaInfo> option) {
		super(option, SchedaytaInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SchedaytaInfo>> getVisitorClassHook() {
		return SchedaytaVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedaytaInfo> mergeHook(List<SchedaytaInfo> baseInfos, List<SchedaytaInfo> selectedInfos) {	
		return SchedaytaMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
