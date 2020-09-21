package br.com.mind5.business.storeText.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StorextSetterCreatedOn extends InfoSetterTemplate<StorextInfo> {
	
	@Override protected StorextInfo setAttrHook(StorextInfo recordInfo) {	
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
