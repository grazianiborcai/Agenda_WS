package br.com.mind5.payment.storePartnerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapMerger;

final class VisiStoparnapMergeToSelect extends ActionVisitorTemplateMergeV2<StoparnapInfo, StoparnapInfo> {
	
	public VisiStoparnapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StoparnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StoparnapInfo>> getActionClassHook() {
		return StdStoparnapSelect.class;
	}
	
	
	
	@Override protected List<StoparnapInfo> mergeHook(List<StoparnapInfo> baseInfos, List<StoparnapInfo> selectedInfos) {	
		return StoparnapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
