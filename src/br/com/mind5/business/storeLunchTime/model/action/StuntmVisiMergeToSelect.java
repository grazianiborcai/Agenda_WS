package br.com.mind5.business.storeLunchTime.model.action;

import java.util.List;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.info.StuntmMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmVisiMergeToSelect extends ActionVisitorTemplateMerge<StuntmInfo, StuntmInfo> {
	
	public StuntmVisiMergeToSelect(DeciTreeOption<StuntmInfo> option) {
		super(option, StuntmInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StuntmInfo>> getVisitorClassHook() {
		return StuntmVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StuntmInfo> mergeHook(List<StuntmInfo> baseInfos, List<StuntmInfo> selectedInfos) {	
		return StuntmMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
