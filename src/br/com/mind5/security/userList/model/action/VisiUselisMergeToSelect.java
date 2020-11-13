package br.com.mind5.security.userList.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.info.UselisMerger;

final class VisiUselisMergeToSelect extends ActionVisitorTemplateMerge<UselisInfo, UselisInfo> {
	
	public VisiUselisMergeToSelect(DeciTreeOption<UselisInfo> option) {
		super(option, UselisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<UselisInfo>> getActionClassHook() {
		return StdUselisDaoSelect.class;
	}
	
	
	
	@Override protected List<UselisInfo> mergeHook(List<UselisInfo> baseInfos, List<UselisInfo> selectedInfos) {	
		return UselisMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
