package br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action;

import java.util.List;

import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.month.model.decisionTree.RootMonthSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info.SowaliveInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info.SowaliveMerger;

final class VisiSowaliveMergeMonth extends ActionVisitorTemplateMerge<SowaliveInfo, MonthInfo> {
	
	public VisiSowaliveMergeMonth(DeciTreeOption<SowaliveInfo> option) {
		super(option, MonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MonthInfo>> getTreeClassHook() {
		return RootMonthSelect.class;
	}
	
	
	
	@Override protected List<SowaliveInfo> mergeHook(List<SowaliveInfo> baseInfos, List<MonthInfo> selectedInfos) {	
		return SowaliveMerger.mergeWithMonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
