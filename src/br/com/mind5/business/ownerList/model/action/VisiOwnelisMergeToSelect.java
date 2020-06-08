package br.com.mind5.business.ownerList.model.action;

import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.info.OwnelisMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnelisMergeToSelect extends ActionVisitorTemplateMergeV2<OwnelisInfo, OwnelisInfo> {
	
	public VisiOwnelisMergeToSelect(DeciTreeOption<OwnelisInfo> option) {
		super(option, OwnelisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<OwnelisInfo>> getActionClassHook() {
		return StdOwnelisDaoSelect.class;
	}
	
	
	
	@Override protected List<OwnelisInfo> mergeHook(List<OwnelisInfo> baseInfos, List<OwnelisInfo> selectedInfos) {	
		return OwnelisMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
