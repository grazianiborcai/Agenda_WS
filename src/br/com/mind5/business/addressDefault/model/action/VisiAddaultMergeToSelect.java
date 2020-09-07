package br.com.mind5.business.addressDefault.model.action;

import java.util.List;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.business.addressDefault.info.AddaultMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddaultMergeToSelect extends ActionVisitorTemplateMergeV2<AddaultInfo, AddaultInfo> {
	
	public VisiAddaultMergeToSelect(DeciTreeOption<AddaultInfo> option) {
		super(option, AddaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<AddaultInfo>> getActionClassHook() {
		return StdAddaultDaoSelect.class;
	}
	
	
	
	@Override protected List<AddaultInfo> mergeHook(List<AddaultInfo> baseInfos, List<AddaultInfo> selectedInfos) {	
		return AddaultMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
