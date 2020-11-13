package br.com.mind5.business.storeWorkTime.model.action;

import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.info.StowotmMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStowotmMergeToUpdate extends ActionVisitorTemplateMerge<StowotmInfo, StowotmInfo> {
	
	public VisiStowotmMergeToUpdate(DeciTreeOption<StowotmInfo> option) {
		super(option, StowotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StowotmInfo>> getActionClassHook() {
		return StdStowotmDaoSelect.class;
	}
	
	
	
	@Override protected List<StowotmInfo> mergeHook(List<StowotmInfo> baseInfos, List<StowotmInfo> selectedInfos) {	
		return StowotmMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}	
}
