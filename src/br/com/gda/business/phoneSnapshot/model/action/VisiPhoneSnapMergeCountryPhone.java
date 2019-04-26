package br.com.gda.business.phoneSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.business.masterData.model.decisionTree.RootCountryPhoneSelect;
import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.business.phoneSnapshot.info.PhoneSnapMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPhoneSnapMergeCountryPhone extends ActionVisitorTemplateMerge<PhoneSnapInfo, CountryPhoneInfo> {
	
	public VisiPhoneSnapMergeCountryPhone(Connection conn, String schemaName) {
		super(conn, schemaName, CountryPhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountryPhoneInfo>> getTreeClassHook() {
		return RootCountryPhoneSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<PhoneSnapInfo>> getMergerClassHook() {
		return PhoneSnapMerger.class;
	}
}
