package br.com.mind5.business.storeProspect.model.action;

import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.info.StoprosMerger;
import br.com.mind5.model.action.ActionStd;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoprosMergeToUpdate extends ActionVisitorTemplateMerge<StoprosInfo, StoprosInfo> {
	
	public VisiStoprosMergeToUpdate(DeciTreeOption<StoprosInfo> option) {
		super(option, StoprosInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StoprosInfo>> getActionClassHook() {
		return StdStoprosDaoSelect.class;
	}
	
	
	
	@Override protected List<StoprosInfo> mergeHook(List<StoprosInfo> baseInfos, List<StoprosInfo> selectedInfos) {	
		return StoprosMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}	
}
