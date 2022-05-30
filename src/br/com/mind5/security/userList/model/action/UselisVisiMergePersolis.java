package br.com.mind5.security.userList.model.action;

import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personList.model.decisionTree.PersolisRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.info.UselisMerger;

public final class UselisVisiMergePersolis extends ActionVisitorTemplateMerge<UselisInfo, PersolisInfo> {
	
	public UselisVisiMergePersolis(DeciTreeOption<UselisInfo> option) {
		super(option, PersolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersolisInfo>> getTreeClassHook() {
		return PersolisRootSelect.class;
	}
	
	
	
	@Override protected List<UselisInfo> mergeHook(List<UselisInfo> baseInfos, List<PersolisInfo> selectedInfos) {	
		return UselisMerger.mergeWithPersolis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
