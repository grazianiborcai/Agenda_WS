package br.com.mind5.business.storeFavorite.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StoriteSetterCreatedOn extends InfoSetterTemplate<StoriteInfo> {
	
	@Override protected StoriteInfo setAttrHook(StoriteInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
