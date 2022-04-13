package br.com.mind5.business.storeLunchTimeSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeLunchTimeSearch.info.StuntmarchInfo;
import br.com.mind5.business.storeLunchTimeSearch.info.StuntmarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmarchVisiMergeToSelect extends ActionVisitorTemplateMerge<StuntmarchInfo, StuntmarchInfo> {
	
	public StuntmarchVisiMergeToSelect(DeciTreeOption<StuntmarchInfo> option) {
		super(option, StuntmarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StuntmarchInfo>> getVisitorClassHook() {
		return StuntmarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StuntmarchInfo> mergeHook(List<StuntmarchInfo> baseInfos, List<StuntmarchInfo> selectedInfos) {	
		return StuntmarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
