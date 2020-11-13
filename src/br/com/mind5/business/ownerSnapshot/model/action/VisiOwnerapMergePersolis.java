package br.com.mind5.business.ownerSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.business.ownerSnapshot.info.OwnerapMerger;
import br.com.mind5.business.personList.info.PersolisCopier;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personList.model.decisionTree.RootPersolisSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerapMergePersolis extends ActionVisitorTemplateMerge<OwnerapInfo, PersolisInfo> {
	
	public VisiOwnerapMergePersolis(DeciTreeOption<OwnerapInfo> option) {
		super(option, PersolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersolisInfo>> getTreeClassHook() {
		return RootPersolisSelect.class;
	}

	

	protected List<PersolisInfo> toActionClassHook(List<OwnerapInfo> baseInfos) {
		return PersolisCopier.copyFromOwnerap(baseInfos);	
	}
	
	
	
	@Override protected List<OwnerapInfo> mergeHook(List<OwnerapInfo> baseInfos, List<PersolisInfo> selectedInfos) {	
		return OwnerapMerger.mergeWithPersolis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
