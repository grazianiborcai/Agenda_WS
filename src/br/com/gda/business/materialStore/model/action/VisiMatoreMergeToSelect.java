package br.com.gda.business.materialStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.info.MatoreMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiMatoreMergeToSelect extends ActionVisitorTemplateMergeV2<MatoreInfo, MatoreInfo> {
	
	public VisiMatoreMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MatoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatoreInfo>> getActionClassHook() {
		return StdMatoreSelect.class;
	}
	
	
	
	@Override protected List<MatoreInfo> mergeHook(List<MatoreInfo> recordInfos, List<MatoreInfo> selectedInfos) {	
		return MatoreMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
