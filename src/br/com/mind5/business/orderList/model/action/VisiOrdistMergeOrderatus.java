package br.com.mind5.business.orderList.model.action;

import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.info.OrdistMerger;
import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;
import br.com.mind5.masterData.orderStatus.model.decisionTree.RootOrderatusSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdistMergeOrderatus extends ActionVisitorTemplateMergeV2<OrdistInfo, OrderatusInfo> {
	
	public VisiOrdistMergeOrderatus(DeciTreeOption<OrdistInfo> option) {
		super(option, OrderatusInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderatusInfo>> getTreeClassHook() {
		return RootOrderatusSelect.class;
	}
	
	
	
	@Override protected List<OrdistInfo> mergeHook(List<OrdistInfo> baseInfos, List<OrderatusInfo> selectedInfos) {	
		return OrdistMerger.mergeWithOrderatus(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
