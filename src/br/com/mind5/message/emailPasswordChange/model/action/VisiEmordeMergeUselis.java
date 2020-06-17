package br.com.mind5.message.emailPasswordChange.model.action;

import java.util.List;

import br.com.mind5.message.emailPasswordChange.info.EmordeInfo;
import br.com.mind5.message.emailPasswordChange.info.EmordeMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.decisionTree.RootUselisSelect;

final class VisiEmordeMergeUselis extends ActionVisitorTemplateMergeV2<EmordeInfo, UselisInfo> {
	
	public VisiEmordeMergeUselis(DeciTreeOption<EmordeInfo> option) {
		super(option, UselisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UselisInfo>> getTreeClassHook() {
		return RootUselisSelect.class;
	}
	
	
	
	@Override protected List<EmordeInfo> mergeHook(List<EmordeInfo> baseInfos, List<UselisInfo> selectedInfos) {	
		return EmordeMerger.mergeWithUselis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
