package br.com.mind5.business.customer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customer.info.CusCopier;
import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiCusMergeToUpdate extends ActionVisitorTemplateMergeV2<CusInfo, CusInfo> {
	
	public VisiCusMergeToUpdate(Connection conn, String schemaName) {
		super(conn, schemaName, CusInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CusInfo>> getActionClassHook() {
		return StdCusSelect.class;
	}
	
	
	
	@Override protected List<CusInfo> toActionClassHook(List<CusInfo> recordInfos) {
		return CusCopier.copyFromCusKey(recordInfos);	
	}
	
	
	
	@Override protected List<CusInfo> mergeHook(List<CusInfo> recordInfos, List<CusInfo> selectedInfos) {	
		return CusMerger.mergeToUpdate(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
