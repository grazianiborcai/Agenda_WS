package br.com.mind5.business.cartItem.model.action;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.info.CartemMerger;
import br.com.mind5.message.sysMessage.info.SymsgCopier;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.decisionTree.RootSymsgSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartemMergeSymsg extends ActionVisitorTemplateMergeV2<CartemInfo, SymsgInfo> {
	
	public VisiCartemMergeSymsg(DeciTreeOption<CartemInfo> option) {
		super(option, SymsgInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SymsgInfo>> getTreeClassHook() {
		return RootSymsgSelect.class;
	}
	
	
	
	@Override protected List<SymsgInfo> toActionClassHook(List<CartemInfo> baseInfos) {
		return SymsgCopier.copyFromCartem(baseInfos);
	}
	
	
	
	@Override protected List<CartemInfo> mergeHook(List<CartemInfo> baseInfos, List<SymsgInfo> selectedInfos) {	
		return CartemMerger.mergeWithSymsg(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
