package br.com.mind5.business.materialList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.info.MatlisMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiMatlisMergeToSelect extends ActionVisitorTemplateMerge<MatlisInfo, MatlisInfo> {
	
	public VisiMatlisMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MatlisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<MatlisInfo>> getActionClassHook() {
		return StdMatlisSelect.class;
	}
	
	
	
	@Override protected List<MatlisInfo> mergeHook(List<MatlisInfo> baseInfos, List<MatlisInfo> selectedInfos) {	
		return MatlisMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
