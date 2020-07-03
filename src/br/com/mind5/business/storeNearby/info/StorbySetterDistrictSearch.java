package br.com.mind5.business.storeNearby.info;

import br.com.mind5.common.StringUtil;
import br.com.mind5.info.InfoSetterTemplate;

public final class StorbySetterDistrictSearch extends InfoSetterTemplate<StorbyInfo> {
	
	@Override protected StorbyInfo setAttrHook(StorbyInfo recordInfo) {		
		recordInfo.districtSearch = StringUtil.normalizeSearch(recordInfo.districtSearch);
		
		return recordInfo;
	}
}
