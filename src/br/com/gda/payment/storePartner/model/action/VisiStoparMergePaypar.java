package br.com.gda.payment.storePartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.business.masterData.model.decisionTree.RootPayparSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.info.StoparMerger;

final class VisiStoparMergePaypar extends ActionVisitorTemplateMergeV2<StoparInfo, PayparInfo> {
	
	public VisiStoparMergePaypar(Connection conn, String schemaName) {
		super(conn, schemaName, PayparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparInfo>> getTreeClassHook() {
		return RootPayparSelect.class;
	}
	
	
	
	@Override protected List<StoparInfo> mergeHook(List<StoparInfo> recordInfos, List<PayparInfo> selectedInfos) {	
		return StoparMerger.mergeWithPaypar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
