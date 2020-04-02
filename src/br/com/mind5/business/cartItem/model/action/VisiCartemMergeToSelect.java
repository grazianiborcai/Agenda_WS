package br.com.mind5.business.cartItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.info.CartemMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiCartemMergeToSelect extends ActionVisitorTemplateMerge<CartemInfo, CartemInfo> {
	
	public VisiCartemMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CartemInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<CartemInfo>> getActionClassHook() {
		return StdCartemSelect.class;
	}
	
	
	
	@Override protected List<CartemInfo> mergeHook(List<CartemInfo> recordInfos, List<CartemInfo> selectedInfos) {	
		return CartemMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
