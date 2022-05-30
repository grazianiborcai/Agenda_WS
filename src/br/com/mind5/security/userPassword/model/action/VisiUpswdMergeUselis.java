package br.com.mind5.security.userPassword.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.decisionTree.UselisRootSelect;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.info.UpswdMerger;

final class VisiUpswdMergeUselis extends ActionVisitorTemplateMerge<UpswdInfo, UselisInfo> {
	
	public VisiUpswdMergeUselis(DeciTreeOption<UpswdInfo> option) {
		super(option, UselisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UselisInfo>> getTreeClassHook() {
		return UselisRootSelect.class;
	}
	
	
	
	@Override protected List<UpswdInfo> mergeHook(List<UpswdInfo> baseInfos, List<UselisInfo> selectedInfos) {	
		return UpswdMerger.mergeWithUselis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
