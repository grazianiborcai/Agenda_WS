package br.com.mind5.message.emailWelcome.model.action;

import java.util.List;

import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.message.emailWelcome.info.EmacomeMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.decisionTree.UselisRootSelect;

public final class EmacomeVisiMergeUselis extends ActionVisitorTemplateMerge<EmacomeInfo, UselisInfo> {
	
	public EmacomeVisiMergeUselis(DeciTreeOption<EmacomeInfo> option) {
		super(option, UselisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UselisInfo>> getTreeClassHook() {
		return UselisRootSelect.class;
	}
	
	
	
	@Override protected List<EmacomeInfo> mergeHook(List<EmacomeInfo> baseInfos, List<UselisInfo> selectedInfos) {	
		return EmacomeMerger.mergeWithUselis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
