package br.com.gda.payment.storePartnerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.gda.payment.storePartnerSnapshot.info.StoparnapMerger;

final class VisiStoparnapMergeToSelect extends ActionVisitorTemplateMergeV2<StoparnapInfo, StoparnapInfo> {
	
	public VisiStoparnapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StoparnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StoparnapInfo>> getActionClassHook() {
		return StdStoparnapSelect.class;
	}
	
	
	
	@Override protected List<StoparnapInfo> mergeHook(List<StoparnapInfo> recordInfos, List<StoparnapInfo> selectedInfos) {	
		return StoparnapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
