package br.com.mind5.business.storeFavorite.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.info.StoriteMerger;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

final class VisiStoriteMergeUsername extends ActionVisitorTemplateMerge<StoriteInfo, UsernameInfo> {
	
	public VisiStoriteMergeUsername(DeciTreeOption<StoriteInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<StoriteInfo> mergeHook(List<StoriteInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return StoriteMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
