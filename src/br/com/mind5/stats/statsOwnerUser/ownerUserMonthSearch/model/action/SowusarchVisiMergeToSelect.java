package br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.info.SowusarchInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.info.SowusarchMerger;

public final class SowusarchVisiMergeToSelect extends ActionVisitorTemplateMerge<SowusarchInfo, SowusarchInfo> {
	
	public SowusarchVisiMergeToSelect(DeciTreeOption<SowusarchInfo> option) {
		super(option, SowusarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SowusarchInfo>> getVisitorClassHook() {
		return SowusarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SowusarchInfo> mergeHook(List<SowusarchInfo> baseInfos, List<SowusarchInfo> selectedInfos) {	
		return SowusarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
