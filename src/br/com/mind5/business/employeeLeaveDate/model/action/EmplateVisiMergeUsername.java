package br.com.mind5.business.employeeLeaveDate.model.action;

import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplateMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.UsernameRootSelect;

public final class EmplateVisiMergeUsername extends ActionVisitorTemplateMerge<EmplateInfo, UsernameInfo> {
	
	public EmplateVisiMergeUsername(DeciTreeOption<EmplateInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return UsernameRootSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<EmplateInfo> baseInfos) {
		return UsernameCopier.copyFromEmplate(baseInfos);	
	}
	
	
	
	@Override protected List<EmplateInfo> mergeHook(List<EmplateInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return EmplateMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
