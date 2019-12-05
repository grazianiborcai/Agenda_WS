package br.com.mind5.business.materialSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiMatsnapMergeToSelect extends ActionVisitorTemplateMergeV2<MatsnapInfo, MatsnapInfo> {
	
	public VisiMatsnapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MatsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatsnapInfo>> getActionClassHook() {
		return StdMatsnapSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> toActionClassHook(List<MatsnapInfo> recordInfos) {
		return recordInfos;	
	}	
	
	
	
	@Override protected List<MatsnapInfo> mergeHook(List<MatsnapInfo> recordInfos, List<MatsnapInfo> selectedInfos) {	
		return MatsnapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
