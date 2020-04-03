package br.com.mind5.business.cartReserve.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.business.cartReserve.info.CarterveMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiCarterveMergeToSelect extends ActionVisitorTemplateMergeV1<CarterveInfo, CarterveInfo> {
	
	public VisiCarterveMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CarterveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<CarterveInfo>> getActionClassHook() {
		return StdCarterveSelect.class;
	}
	
	
	
	@Override protected List<CarterveInfo> mergeHook(List<CarterveInfo> baseInfos, List<CarterveInfo> selectedInfos) {	
		return CarterveMerger.mergeToSelect(selectedInfos, baseInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
