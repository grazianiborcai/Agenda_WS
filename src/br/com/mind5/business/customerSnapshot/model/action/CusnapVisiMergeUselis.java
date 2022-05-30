package br.com.mind5.business.customerSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.customerSnapshot.info.CusnapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.decisionTree.UselisRootSelect;

public final class CusnapVisiMergeUselis extends ActionVisitorTemplateMerge<CusnapInfo, UselisInfo> {
	
	public CusnapVisiMergeUselis(DeciTreeOption<CusnapInfo> option) {
		super(option, UselisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UselisInfo>> getTreeClassHook() {
		return UselisRootSelect.class;
	}
	
	
	
	@Override protected List<CusnapInfo> mergeHook(List<CusnapInfo> baseInfos, List<UselisInfo> selectedInfos) {	
		return CusnapMerger.mergeWithUselis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
