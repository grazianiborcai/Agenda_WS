package br.com.mind5.business.moonCalendar.model.action;

import java.util.List;

import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.business.moonCalendar.info.MooncalMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMooncalMergeToSelect extends ActionVisitorTemplateMergeV2<MooncalInfo, MooncalInfo> {
	
	public VisiMooncalMergeToSelect(DeciTreeOption<MooncalInfo> option) {
		super(option, MooncalInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<MooncalInfo>> getActionClassHook() {
		return StdMooncalDaoSelect.class;
	}
	
	
	
	@Override protected List<MooncalInfo> mergeHook(List<MooncalInfo> baseInfos, List<MooncalInfo> selectedInfos) {	
		return MooncalMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
