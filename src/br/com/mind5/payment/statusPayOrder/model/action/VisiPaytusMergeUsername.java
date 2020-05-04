package br.com.mind5.payment.statusPayOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.info.PaytusMerger;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

final class VisiPaytusMergeUsername extends ActionVisitorTemplateMergeV2<PaytusInfo, UsernameInfo> {
	
	public VisiPaytusMergeUsername(DeciTreeOption<PaytusInfo> option) {
		super(option, UsernameInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<PaytusInfo> baseInfos) {
		return UsernameCopier.copyFromPaytus(baseInfos);	
	}
	
	
	
	@Override protected List<PaytusInfo> mergeHook(List<PaytusInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return PaytusMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
