package br.com.mind5.business.storeProspect.model.action;

import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.info.StoprosMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoprosMergeToSelect extends ActionVisitorTemplateMergeV2<StoprosInfo, StoprosInfo> {
	
	public VisiStoprosMergeToSelect(DeciTreeOption<StoprosInfo> option) {
		super(option, StoprosInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<StoprosInfo>> getActionClassHook() {
		return StdStoprosDaoSelect.class;
	}
	
	
	
	@Override protected List<StoprosInfo> mergeHook(List<StoprosInfo> baseInfos, List<StoprosInfo> selectedInfos) {	
		return StoprosMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}	
}
