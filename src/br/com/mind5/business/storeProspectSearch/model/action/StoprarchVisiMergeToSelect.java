package br.com.mind5.business.storeProspectSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.business.storeProspectSearch.info.StoprarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoprarchVisiMergeToSelect extends ActionVisitorTemplateMerge<StoprarchInfo, StoprarchInfo> {
	
	public StoprarchVisiMergeToSelect(DeciTreeOption<StoprarchInfo> option) {
		super(option, StoprarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StoprarchInfo>> getVisitorClassHook() {
		return StoprarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StoprarchInfo> mergeHook(List<StoprarchInfo> baseInfos, List<StoprarchInfo> selectedInfos) {	
		return StoprarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}	
}
