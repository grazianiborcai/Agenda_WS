package br.com.mind5.business.cartItem.model.action;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.info.CartemMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

final class VisiCartemMergeUsername extends ActionVisitorTemplateMerge<CartemInfo, UsernameInfo> {
	
	public VisiCartemMergeUsername(DeciTreeOption<CartemInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<CartemInfo> mergeHook(List<CartemInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return CartemMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
