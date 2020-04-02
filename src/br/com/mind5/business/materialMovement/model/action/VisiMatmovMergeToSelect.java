package br.com.mind5.business.materialMovement.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.info.MatmovMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiMatmovMergeToSelect extends ActionVisitorTemplateMerge<MatmovInfo, MatmovInfo> {
	
	public VisiMatmovMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MatmovInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<MatmovInfo>> getActionClassHook() {
		return StdMatmovSelect.class;
	}
	
	
	
	@Override protected List<MatmovInfo> mergeHook(List<MatmovInfo> recordInfos, List<MatmovInfo> selectedInfos) {	
		return MatmovMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
