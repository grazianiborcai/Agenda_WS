package br.com.mind5.business.storeProspect.model.action;

import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.info.StoprosMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoprosMergeToUpdate extends ActionVisitorTemplateMergeV2<StoprosInfo, StoprosInfo> {
	
	public VisiStoprosMergeToUpdate(DeciTreeOption<StoprosInfo> option) {
		super(option, StoprosInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<StoprosInfo>> getActionClassHook() {
		return StdStoprosDaoSelect.class;
	}
	
	
	
	@Override protected List<StoprosInfo> mergeHook(List<StoprosInfo> baseInfos, List<StoprosInfo> selectedInfos) {	
		return StoprosMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}	
}
