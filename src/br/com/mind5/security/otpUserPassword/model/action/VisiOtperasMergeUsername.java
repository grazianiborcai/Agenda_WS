package br.com.mind5.security.otpUserPassword.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.info.OtperasMerger;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

final class VisiOtperasMergeUsername extends ActionVisitorTemplateMerge<OtperasInfo, UsernameInfo> {
	
	public VisiOtperasMergeUsername(DeciTreeOption<OtperasInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<OtperasInfo> mergeHook(List<OtperasInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return OtperasMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
