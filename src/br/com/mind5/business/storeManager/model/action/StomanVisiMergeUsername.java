package br.com.mind5.business.storeManager.model.action;

import java.util.List;

import br.com.mind5.business.storeManager.info.StomanInfo;
import br.com.mind5.business.storeManager.info.StomanMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.UsernameRootSelect;

public final class StomanVisiMergeUsername extends ActionVisitorTemplateMerge<StomanInfo, UsernameInfo> {
	
	public StomanVisiMergeUsername(DeciTreeOption<StomanInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return UsernameRootSelect.class;
	}
	
	
	
	@Override protected List<StomanInfo> mergeHook(List<StomanInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return StomanMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
