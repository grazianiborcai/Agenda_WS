package br.com.gda.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.customerSearch.info.CusarchCopier;
import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.business.customerSearch.model.decisionTree.RootCusarchSelect;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.info.OrderMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOrderMergeCusarch extends ActionVisitorTemplateMergeV2<OrderInfo, CusarchInfo> {
	
	public VisiOrderMergeCusarch(Connection conn, String schemaName) {
		super(conn, schemaName, CusarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusarchInfo>> getTreeClassHook() {
		return RootCusarchSelect.class;
	}
	
	
	
	protected List<CusarchInfo> toActionClassHook(List<OrderInfo> recordInfos) {
		return CusarchCopier.copyFromOrder(recordInfos);	
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> recordInfos, List<CusarchInfo> selectedInfos) {	
		return OrderMerger.mergeWithCusarch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
