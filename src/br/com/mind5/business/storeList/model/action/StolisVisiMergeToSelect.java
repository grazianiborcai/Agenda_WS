package br.com.mind5.business.storeList.model.action;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.info.StolisMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolisVisiMergeToSelect extends ActionVisitorTemplateMerge<StolisInfo, StolisInfo> {
	
	public StolisVisiMergeToSelect(DeciTreeOption<StolisInfo> option) {
		super(option, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StolisInfo>> getVisitorClassHook() {
		return StolisVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StolisInfo> mergeHook(List<StolisInfo> baseInfos, List<StolisInfo> selectedInfos) {	
		return StolisMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
