package br.com.mind5.business.orderHistoryDecorated.model.action;

import java.util.List;

import br.com.mind5.business.orderHistoryDecorated.info.OrdorycoInfo;
import br.com.mind5.business.orderHistoryDecorated.info.OrdorycoMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

final class VisiOrdorycoMergeUsername extends ActionVisitorTemplateMerge<OrdorycoInfo, UsernameInfo> {
	
	public VisiOrdorycoMergeUsername(DeciTreeOption<OrdorycoInfo> option) {
		super(option, UsernameInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<OrdorycoInfo> mergeHook(List<OrdorycoInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return OrdorycoMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
