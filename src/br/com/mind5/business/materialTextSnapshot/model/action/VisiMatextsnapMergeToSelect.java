package br.com.mind5.business.materialTextSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiMatextsnapMergeToSelect extends ActionVisitorTemplateMergeV2<MatextsnapInfo, MatextsnapInfo> {
	
	public VisiMatextsnapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MatextsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatextsnapInfo>> getActionClassHook() {
		return StdMatextsnapSelect.class;
	}
	
	
	
	@Override protected List<MatextsnapInfo> toActionClassHook(List<MatextsnapInfo> recordInfos) {
		return recordInfos;	
	}	
	
	
	
	@Override protected List<MatextsnapInfo> mergeHook(List<MatextsnapInfo> recordInfos, List<MatextsnapInfo> selectedInfos) {	
		return MatextsnapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
