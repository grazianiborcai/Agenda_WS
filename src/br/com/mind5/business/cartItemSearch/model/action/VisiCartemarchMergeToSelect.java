package br.com.mind5.business.cartItemSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.business.cartItemSearch.info.CartemarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiCartemarchMergeToSelect extends ActionVisitorTemplateMergeV2<CartemarchInfo, CartemarchInfo> {
	
	public VisiCartemarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CartemarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CartemarchInfo>> getActionClassHook() {
		return StdCartemarchSelect.class;
	}
	
	
	
	@Override protected List<CartemarchInfo> mergeHook(List<CartemarchInfo> recordInfos, List<CartemarchInfo> selectedInfos) {	
		return CartemarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
