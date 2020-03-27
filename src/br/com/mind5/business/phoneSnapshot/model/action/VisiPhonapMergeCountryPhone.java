package br.com.mind5.business.phoneSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootCountryPhoneSelect;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiPhonapMergeCountryPhone extends ActionVisitorTemplateMerge<PhonapInfo, CountryPhoneInfo> {
	
	public VisiPhonapMergeCountryPhone(Connection conn, String schemaName) {
		super(conn, schemaName, CountryPhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountryPhoneInfo>> getTreeClassHook() {
		return RootCountryPhoneSelect.class;
	}
	
	
	
	@Override protected List<PhonapInfo> mergeHook(List<PhonapInfo> recordInfos, List<CountryPhoneInfo> selectedInfos) {	
		return PhonapMerger.mergeWithCountryPhone(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.MERGE_WHEN_EMPTY;
	}
}
