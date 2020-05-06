package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchCopier;
import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.decisionTree.RootCusarchSelect;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderMergeCusarch extends ActionVisitorTemplateMergeV2<OrderInfo, CusarchInfo> {
	
	public VisiOrderMergeCusarch(DeciTreeOption<OrderInfo> option) { 
		super(option, CusarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusarchInfo>> getTreeClassHook() {
		return RootCusarchSelect.class;
	}
	
	
	
	protected List<CusarchInfo> toActionClassHook(List<OrderInfo> baseInfos) {
		return CusarchCopier.copyFromOrder(baseInfos);	
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> baseInfos, List<CusarchInfo> selectedInfos) {	
		return OrderMerger.mergeWithCusarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
