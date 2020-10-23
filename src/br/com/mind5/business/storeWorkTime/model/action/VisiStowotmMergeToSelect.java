package br.com.mind5.business.storeWorkTime.model.action;

import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.info.StowotmMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStowotmMergeToSelect extends ActionVisitorTemplateMergeV2<StowotmInfo, StowotmInfo> {
	
	public VisiStowotmMergeToSelect(DeciTreeOption<StowotmInfo> option) {
		super(option, StowotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<StowotmInfo>> getActionClassHook() {
		return StdStowotmDaoSelect.class;
	}
	
	
	
	@Override protected List<StowotmInfo> mergeHook(List<StowotmInfo> baseInfos, List<StowotmInfo> selectedInfos) {	
		return StowotmMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
