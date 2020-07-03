package br.com.mind5.business.storeNearby.info;

import br.com.mind5.common.StringUtil;
import br.com.mind5.info.InfoSetterTemplate;

public final class StorbySetterNameSearch extends InfoSetterTemplate<StorbyInfo> {
	
	@Override protected StorbyInfo setAttrHook(StorbyInfo recordInfo) {		
		recordInfo.nameSearch = StringUtil.normalizeSearch(recordInfo.nameSearch);
		
		return recordInfo;
	}
}
