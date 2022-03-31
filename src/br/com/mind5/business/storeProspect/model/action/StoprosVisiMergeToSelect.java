package br.com.mind5.business.storeProspect.model.action;

import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.info.StoprosMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoprosVisiMergeToSelect extends ActionVisitorTemplateMerge<StoprosInfo, StoprosInfo> {
	
	public StoprosVisiMergeToSelect(DeciTreeOption<StoprosInfo> option) {
		super(option, StoprosInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StoprosInfo>> getVisitorClassHook() {
		return StoprosVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StoprosInfo> mergeHook(List<StoprosInfo> baseInfos, List<StoprosInfo> selectedInfos) {	
		return StoprosMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}	
}
