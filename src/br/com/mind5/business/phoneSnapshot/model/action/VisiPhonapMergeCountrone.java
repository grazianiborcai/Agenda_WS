package br.com.mind5.business.phoneSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapMerger;
import br.com.mind5.masterData.countryPhone.info.CountroneInfo;
import br.com.mind5.masterData.countryPhone.model.decisionTree.RootCountroneSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiPhonapMergeCountrone extends ActionVisitorTemplateMergeV1<PhonapInfo, CountroneInfo> {
	
	public VisiPhonapMergeCountrone(Connection conn, String schemaName) {
		super(conn, schemaName, CountroneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountroneInfo>> getTreeClassHook() {
		return RootCountroneSelect.class;
	}
	
	
	
	@Override protected List<PhonapInfo> mergeHook(List<PhonapInfo> recordInfos, List<CountroneInfo> selectedInfos) {	
		return PhonapMerger.mergeWithCountrone(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
