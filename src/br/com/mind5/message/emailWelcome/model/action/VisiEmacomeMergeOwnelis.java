package br.com.mind5.message.emailWelcome.model.action;

import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.model.decisionTree.RootOwnelisSelect;
import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.message.emailWelcome.info.EmacomeMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmacomeMergeOwnelis extends ActionVisitorTemplateMergeV2<EmacomeInfo, OwnelisInfo> {
	
	public VisiEmacomeMergeOwnelis(DeciTreeOption<EmacomeInfo> option) {
		super(option, OwnelisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwnelisInfo>> getTreeClassHook() {
		return RootOwnelisSelect.class;
	}
	
	
	
	@Override protected List<EmacomeInfo> mergeHook(List<EmacomeInfo> baseInfos, List<OwnelisInfo> selectedInfos) {	
		return EmacomeMerger.mergeWithOwnelis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
