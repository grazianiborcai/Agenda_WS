package br.com.mind5.business.storeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootCurrencySelect;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.info.StorapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiStorapMergeCurrency extends ActionVisitorTemplateMergeV2<StorapInfo, CurrencyInfo> {
	
	public VisiStorapMergeCurrency(Connection conn, String schemaName) {
		super(conn, schemaName, CurrencyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CurrencyInfo>> getTreeClassHook() {
		return RootCurrencySelect.class;
	}
	
	
	
	@Override protected List<StorapInfo> mergeHook(List<StorapInfo> recordInfos, List<CurrencyInfo> selectedInfos) {	
		return StorapMerger.mergeWithCurrency(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
