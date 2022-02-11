package br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info.SowaliveInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info.SowaliveMerger;

final class VisiSowaliveMergeToSelect extends ActionVisitorTemplateMerge<SowaliveInfo, SowaliveInfo> {
	
	public VisiSowaliveMergeToSelect(DeciTreeOption<SowaliveInfo> option) {
		super(option, SowaliveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SowaliveInfo>> getActionClassHook() {
		return StdSowaliveDaoSelect.class;
	}
	
	
	
	@Override protected List<SowaliveInfo> mergeHook(List<SowaliveInfo> baseInfos, List<SowaliveInfo> selectedInfos) {	
		return SowaliveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
