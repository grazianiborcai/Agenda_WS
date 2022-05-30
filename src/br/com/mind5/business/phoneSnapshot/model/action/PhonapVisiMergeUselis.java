package br.com.mind5.business.phoneSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapMerger;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.info.UselisCopier;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.decisionTree.UselisRootSelect;

public final class PhonapVisiMergeUselis extends ActionVisitorTemplateMerge<PhonapInfo, UselisInfo> {
	
	public PhonapVisiMergeUselis(DeciTreeOption<PhonapInfo> option) {
		super(option, UselisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UselisInfo>> getTreeClassHook() {
		return UselisRootSelect.class;
	}

	
	
	protected List<UselisInfo> toActionClassHook(List<PhonapInfo> baseInfos) {
		return UselisCopier.copyFromPhonap(baseInfos);	
	}	
	
	
	@Override protected List<PhonapInfo> mergeHook(List<PhonapInfo> baseInfos, List<UselisInfo> selectedInfos) {	
		return PhonapMerger.mergeWithUselis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
