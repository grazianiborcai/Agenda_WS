package br.com.mind5.business.orderList.model.action;

import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.info.OrdistMerger;
import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;
import br.com.mind5.masterData.orderStatus.model.decisionTree.OrderatusRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdistVisiMergeOrderatus extends ActionVisitorTemplateMerge<OrdistInfo, OrderatusInfo> {
	
	public OrdistVisiMergeOrderatus(DeciTreeOption<OrdistInfo> option) {
		super(option, OrderatusInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderatusInfo>> getTreeClassHook() {
		return OrderatusRootSelect.class;
	}
	
	
	
	@Override protected List<OrdistInfo> mergeHook(List<OrdistInfo> baseInfos, List<OrderatusInfo> selectedInfos) {	
		return OrdistMerger.mergeWithOrderatus(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
