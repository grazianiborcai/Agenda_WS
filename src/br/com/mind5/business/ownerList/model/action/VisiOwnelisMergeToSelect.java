package br.com.mind5.business.ownerList.model.action;

import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.info.OwnelisMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnelisMergeToSelect extends ActionVisitorTemplateMerge<OwnelisInfo, OwnelisInfo> {
	
	public VisiOwnelisMergeToSelect(DeciTreeOption<OwnelisInfo> option) {
		super(option, OwnelisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OwnelisInfo>> getActionClassHook() {
		return StdOwnelisDaoSelect.class;
	}
	
	
	
	@Override protected List<OwnelisInfo> mergeHook(List<OwnelisInfo> baseInfos, List<OwnelisInfo> selectedInfos) {	
		return OwnelisMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
