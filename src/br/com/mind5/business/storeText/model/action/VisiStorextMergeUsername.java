package br.com.mind5.business.storeText.model.action;

import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.info.StorextMerger;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

final class VisiStorextMergeUsername extends ActionVisitorTemplateMerge<StorextInfo, UsernameInfo> {
	
	public VisiStorextMergeUsername(DeciTreeOption<StorextInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<StorextInfo> mergeHook(List<StorextInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return StorextMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
