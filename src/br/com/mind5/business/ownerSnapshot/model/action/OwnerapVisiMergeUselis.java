package br.com.mind5.business.ownerSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.business.ownerSnapshot.info.OwnerapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.info.UselisCopier;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.decisionTree.UselisRootSelect;

public final class OwnerapVisiMergeUselis extends ActionVisitorTemplateMerge<OwnerapInfo, UselisInfo> {
	
	public OwnerapVisiMergeUselis(DeciTreeOption<OwnerapInfo> option) {
		super(option, UselisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UselisInfo>> getTreeClassHook() {
		return UselisRootSelect.class;
	}

	
	
	protected List<UselisInfo> toActionClassHook(List<OwnerapInfo> baseInfos) {
		return UselisCopier.copyFromOwnerap(baseInfos);	
	}	
	
	
	@Override protected List<OwnerapInfo> mergeHook(List<OwnerapInfo> baseInfos, List<UselisInfo> selectedInfos) {	
		return OwnerapMerger.mergeWithUselis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
