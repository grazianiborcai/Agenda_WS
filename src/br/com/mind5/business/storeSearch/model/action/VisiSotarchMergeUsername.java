package br.com.mind5.business.storeSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSearch.info.SotarchMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

final class VisiSotarchMergeUsername extends ActionVisitorTemplateMerge<SotarchInfo, UsernameInfo> {
	
	public VisiSotarchMergeUsername(DeciTreeOption<SotarchInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<SotarchInfo> baseInfos) {
		return UsernameCopier.copyFromSotarch(baseInfos);	
	}
	
	
	
	@Override protected List<SotarchInfo> mergeHook(List<SotarchInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return SotarchMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
