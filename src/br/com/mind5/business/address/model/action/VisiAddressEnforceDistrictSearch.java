package br.com.mind5.business.address.model.action;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressSetterDistrictSearch;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddressEnforceDistrictSearch extends ActionVisitorTemplateEnforce<AddressInfo> {
	
	public VisiAddressEnforceDistrictSearch(DeciTreeOption<AddressInfo> option) {
		super(option);
	}

	
	
	@Override protected AddressInfo enforceHook(AddressInfo recordInfo) {
		InfoSetter<AddressInfo> attrSetter = new AddressSetterDistrictSearch();
		return attrSetter.setAttr(recordInfo);
	}
}
