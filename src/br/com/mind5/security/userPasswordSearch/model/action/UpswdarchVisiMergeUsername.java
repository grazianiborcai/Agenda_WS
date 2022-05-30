package br.com.mind5.security.userPasswordSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchInfo;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchMerger;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.UsernameRootSelect;

public final class UpswdarchVisiMergeUsername extends ActionVisitorTemplateMerge<UpswdarchInfo, UsernameInfo> {
	
	public UpswdarchVisiMergeUsername(DeciTreeOption<UpswdarchInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return UsernameRootSelect.class;
	}
	
	
	
	@Override protected List<UpswdarchInfo> mergeHook(List<UpswdarchInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return UpswdarchMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
