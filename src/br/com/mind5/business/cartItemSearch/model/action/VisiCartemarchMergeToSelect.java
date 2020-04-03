package br.com.mind5.business.cartItemSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.business.cartItemSearch.info.CartemarchMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiCartemarchMergeToSelect extends ActionVisitorTemplateMergeV1<CartemarchInfo, CartemarchInfo> {
	
	public VisiCartemarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CartemarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<CartemarchInfo>> getActionClassHook() {
		return StdCartemarchSelect.class;
	}
	
	
	
	@Override protected List<CartemarchInfo> mergeHook(List<CartemarchInfo> recordInfos, List<CartemarchInfo> selectedInfos) {	
		return CartemarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
