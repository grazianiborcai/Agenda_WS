package br.com.mind5.message.emailWelcome.model.action;

import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.model.decisionTree.OwnelisRootSelect;
import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.message.emailWelcome.info.EmacomeMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmacomeMergeOwnelis extends ActionVisitorTemplateMerge<EmacomeInfo, OwnelisInfo> {
	
	public VisiEmacomeMergeOwnelis(DeciTreeOption<EmacomeInfo> option) {
		super(option, OwnelisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwnelisInfo>> getTreeClassHook() {
		return OwnelisRootSelect.class;
	}
	
	
	
	@Override protected List<EmacomeInfo> mergeHook(List<EmacomeInfo> baseInfos, List<OwnelisInfo> selectedInfos) {	
		return EmacomeMerger.mergeWithOwnelis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
