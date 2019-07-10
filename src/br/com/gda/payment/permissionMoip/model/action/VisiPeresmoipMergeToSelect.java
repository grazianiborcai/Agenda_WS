package br.com.gda.payment.permissionMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.payment.permissionMoip.info.PeresmoipInfo;
import br.com.gda.payment.permissionMoip.info.PeresmoipMerger;

final class VisiPeresmoipMergeToSelect extends ActionVisitorTemplateMergeV2<PeresmoipInfo, PeresmoipInfo> {
	
	public VisiPeresmoipMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, PeresmoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PeresmoipInfo>> getActionClassHook() {
		return StdPeresmoipSelect.class;
	}
	
	
	
	@Override protected List<PeresmoipInfo> mergeHook(List<PeresmoipInfo> recordInfos, List<PeresmoipInfo> selectedInfos) {	
		return PeresmoipMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
