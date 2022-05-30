package br.com.mind5.security.otpUserPassword.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.info.OtperasMerger;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.decisionTree.UselisRootSelect;

public final class OtperasVisiMergeUselis extends ActionVisitorTemplateMerge<OtperasInfo, UselisInfo> {
	
	public OtperasVisiMergeUselis(DeciTreeOption<OtperasInfo> option) {
		super(option, UselisInfo.class);
	}
	
	
	
	protected Class<? extends DeciTree<UselisInfo>> getTreeClassHook() {
		return UselisRootSelect.class;
	}
	
	
	
	@Override protected List<OtperasInfo> mergeHook(List<OtperasInfo> baseInfos, List<UselisInfo> selectedInfos) {	
		return OtperasMerger.mergeWithUselis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
