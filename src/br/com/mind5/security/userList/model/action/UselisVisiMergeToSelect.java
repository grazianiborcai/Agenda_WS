package br.com.mind5.security.userList.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.info.UselisMerger;

public final class UselisVisiMergeToSelect extends ActionVisitorTemplateMerge<UselisInfo, UselisInfo> {
	
	public UselisVisiMergeToSelect(DeciTreeOption<UselisInfo> option) {
		super(option, UselisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<UselisInfo>> getVisitorClassHook() {
		return UselisVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<UselisInfo> mergeHook(List<UselisInfo> baseInfos, List<UselisInfo> selectedInfos) {	
		return UselisMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
