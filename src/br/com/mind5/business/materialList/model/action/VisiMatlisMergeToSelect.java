package br.com.mind5.business.materialList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.info.MatlisMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiMatlisMergeToSelect extends ActionVisitorTemplateMergeV2<MatlisInfo, MatlisInfo> {
	
	public VisiMatlisMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MatlisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatlisInfo>> getActionClassHook() {
		return StdMatlisSelect.class;
	}
	
	
	
	@Override protected List<MatlisInfo> mergeHook(List<MatlisInfo> recordInfos, List<MatlisInfo> selectedInfos) {	
		return MatlisMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
