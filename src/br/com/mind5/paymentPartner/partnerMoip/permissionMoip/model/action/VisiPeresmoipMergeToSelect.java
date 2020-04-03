package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipMerger;

final class VisiPeresmoipMergeToSelect extends ActionVisitorTemplateMergeV1<PeresmoipInfo, PeresmoipInfo> {
	
	public VisiPeresmoipMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, PeresmoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<PeresmoipInfo>> getActionClassHook() {
		return StdPeresmoipSelect.class;
	}
	
	
	
	@Override protected List<PeresmoipInfo> mergeHook(List<PeresmoipInfo> baseInfos, List<PeresmoipInfo> selectedInfos) {	
		return PeresmoipMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
