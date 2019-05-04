package br.com.gda.business.address.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.info.AddressMerger;
import br.com.gda.business.masterData.info.CountryInfo;
import br.com.gda.business.masterData.model.decisionTree.RootCountrySelect;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiAddressMergeCountry extends ActionVisitorTemplateMerge_<AddressInfo, CountryInfo> {
	
	public VisiAddressMergeCountry(Connection conn, String schemaName) {
		super(conn, schemaName, CountryInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountryInfo>> getTreeClassHook() {
		return RootCountrySelect.class;
	}
	
	
	
	@Override protected List<AddressInfo> mergeHook(List<AddressInfo> recordInfos, List<CountryInfo> selectedInfos) {
		return AddressMerger.mergeWithCountry(selectedInfos, recordInfos);
	}
}
