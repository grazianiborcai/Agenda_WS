package br.com.mind5.business.orderList.model.action;

import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.info.OrdistMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

public final class OrdistVisiMergeUsername extends ActionVisitorTemplateMerge<OrdistInfo, UsernameInfo> {
	
	public OrdistVisiMergeUsername(DeciTreeOption<OrdistInfo> option) {
		super(option, UsernameInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<OrdistInfo> mergeHook(List<OrdistInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return OrdistMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<OrdistInfo> recordInfos) {
		return UsernameCopier.copyFromOrdist(recordInfos);	
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
