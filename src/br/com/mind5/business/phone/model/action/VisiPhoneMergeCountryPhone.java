package br.com.mind5.business.phone.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootCountryPhoneSelect;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiPhoneMergeCountryPhone extends ActionVisitorTemplateMergeV2<PhoneInfo, CountryPhoneInfo> {
	
	public VisiPhoneMergeCountryPhone(Connection conn, String schemaName) {
		super(conn, schemaName, CountryPhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountryPhoneInfo>> getTreeClassHook() {
		return RootCountryPhoneSelect.class;
	}
	
	
	
	@Override protected List<PhoneInfo> mergeHook(List<PhoneInfo> recordInfos, List<CountryPhoneInfo> selectedInfos) {	
		return PhoneMerger.mergeWithCountryPhone(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
