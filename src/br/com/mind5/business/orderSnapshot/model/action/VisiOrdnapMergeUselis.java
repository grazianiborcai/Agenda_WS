package br.com.mind5.business.orderSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.business.orderSnapshot.info.OrdnapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.decisionTree.RootUselisSelect;

final class VisiOrdnapMergeUselis extends ActionVisitorTemplateMerge<OrdnapInfo, UselisInfo> {
	
	public VisiOrdnapMergeUselis(DeciTreeOption<OrdnapInfo> option) {
		super(option, UselisInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<UselisInfo>> getTreeClassHook() {
		return RootUselisSelect.class;
	}
	
	
	
	@Override protected List<OrdnapInfo> mergeHook(List<OrdnapInfo> baseInfos, List<UselisInfo> selectedInfos) {	
		return OrdnapMerger.mergeWithUselis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
