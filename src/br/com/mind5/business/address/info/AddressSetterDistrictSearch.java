package br.com.mind5.business.address.info;

import br.com.mind5.common.StringUtil;
import br.com.mind5.info.InfoSetterTemplate;

public final class AddressSetterDistrictSearch extends InfoSetterTemplate<AddressInfo> {
	
	@Override protected AddressInfo setAttrHook(AddressInfo recordInfo) {
		if (recordInfo.city 	== null	||
			recordInfo.district == null		)
			
			return recordInfo;
		
		recordInfo.districtSearch = recordInfo.city + recordInfo.district;
		recordInfo.districtSearch = StringUtil.normalizeSearch(recordInfo.districtSearch);
		
		return recordInfo;
	}
}
