package br.com.gda.payment.storePartnerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.business.masterData.model.decisionTree.RootPayparSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.gda.payment.storePartnerSnapshot.info.StoparnapMerger;

final class VisiStoparnapMergePaypar extends ActionVisitorTemplateMergeV2<StoparnapInfo, PayparInfo> {
	
	public VisiStoparnapMergePaypar(Connection conn, String schemaName) {
		super(conn, schemaName, PayparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparInfo>> getTreeClassHook() {
		return RootPayparSelect.class;
	}
	
	
	
	@Override protected List<StoparnapInfo> mergeHook(List<StoparnapInfo> recordInfos, List<PayparInfo> selectedInfos) {	
		return StoparnapMerger.mergeWithPaypar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
