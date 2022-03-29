package br.com.mind5.business.orderList.model.action;

import java.util.List;

import br.com.mind5.business.orderItemCounter.info.OrdereouInfo;
import br.com.mind5.business.orderItemCounter.model.decisionTree.RootOrdereouSelect;
import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.info.OrdistMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdistVisiMergeOrdereou extends ActionVisitorTemplateMerge<OrdistInfo, OrdereouInfo> {
	
	public OrdistVisiMergeOrdereou(DeciTreeOption<OrdistInfo> option) {
		super(option, OrdereouInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdereouInfo>> getTreeClassHook() {
		return RootOrdereouSelect.class;
	}
	
	
	
	@Override protected List<OrdistInfo> mergeHook(List<OrdistInfo> baseInfos, List<OrdereouInfo> selectedInfos) {	
		return OrdistMerger.mergeWithOrdereou(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
