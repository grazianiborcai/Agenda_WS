package br.com.gda.business.phone.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.business.masterData.model.decisionTree.RootCountryPhoneSelect;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.info.PhoneMerger;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPhoneMergeCountryPhone extends ActionVisitorTemplateMerge<PhoneInfo, CountryPhoneInfo> {
	
	public VisiPhoneMergeCountryPhone(Connection conn, String schemaName) {
		super(conn, schemaName, CountryPhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountryPhoneInfo>> getTreeClassHook() {
		return RootCountryPhoneSelect.class;
	}
	
	
	
	@Override protected List<PhoneInfo> mergeHook(List<PhoneInfo> recordInfos, List<CountryPhoneInfo> selectedInfos) {	
		return PhoneMerger.mergeWithCountryPhone(selectedInfos, recordInfos);
	}
}
