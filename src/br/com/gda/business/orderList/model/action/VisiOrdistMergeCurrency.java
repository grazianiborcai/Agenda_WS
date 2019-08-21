package br.com.gda.business.orderList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.orderList.info.OrdistInfo;
import br.com.gda.business.orderList.info.OrdistMerger;
import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.model.decisionTree.RootCurrencySelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOrdistMergeCurrency extends ActionVisitorTemplateMergeV2<OrdistInfo, CurrencyInfo> {
	
	public VisiOrdistMergeCurrency(Connection conn, String schemaName) {
		super(conn, schemaName, CurrencyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CurrencyInfo>> getTreeClassHook() {
		return RootCurrencySelect.class;
	}
	
	
	
	@Override protected List<OrdistInfo> mergeHook(List<OrdistInfo> recordInfos, List<CurrencyInfo> selectedInfos) {	
		return OrdistMerger.mergeWithCurrency(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
