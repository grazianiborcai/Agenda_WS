package br.com.mind5.business.materialMovementSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.business.materialMovementSearch.info.MatmarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiMatmarchMergeToSelect extends ActionVisitorTemplateMergeV2<MatmarchInfo, MatmarchInfo> {
	
	public VisiMatmarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MatmarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatmarchInfo>> getActionClassHook() {
		return StdMatmarchSelect.class;
	}
	
	
	
	@Override protected List<MatmarchInfo> mergeHook(List<MatmarchInfo> recordInfos, List<MatmarchInfo> selectedInfos) {	
		return MatmarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
