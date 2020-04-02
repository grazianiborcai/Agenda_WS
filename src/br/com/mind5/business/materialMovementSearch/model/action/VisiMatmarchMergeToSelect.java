package br.com.mind5.business.materialMovementSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.business.materialMovementSearch.info.MatmarchMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiMatmarchMergeToSelect extends ActionVisitorTemplateMerge<MatmarchInfo, MatmarchInfo> {
	
	public VisiMatmarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MatmarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<MatmarchInfo>> getActionClassHook() {
		return StdMatmarchSelect.class;
	}
	
	
	
	@Override protected List<MatmarchInfo> mergeHook(List<MatmarchInfo> recordInfos, List<MatmarchInfo> selectedInfos) {	
		return MatmarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
