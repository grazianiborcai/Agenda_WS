package br.com.mind5.business.personList.model.action;

import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personList.info.PersolisMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPersolisMergeToSelect extends ActionVisitorTemplateMergeV2<PersolisInfo, PersolisInfo> {
	
	public VisiPersolisMergeToSelect(DeciTreeOption<PersolisInfo> option) {
		super(option, PersolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<PersolisInfo>> getActionClassHook() {
		return StdPersolisDaoSelect.class;
	}
	
	
	
	@Override protected List<PersolisInfo> mergeHook(List<PersolisInfo> baseInfos, List<PersolisInfo> selectedInfos) {	
		return PersolisMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
