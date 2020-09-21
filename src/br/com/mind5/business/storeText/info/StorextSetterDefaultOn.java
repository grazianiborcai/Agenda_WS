package br.com.mind5.business.storeText.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StorextSetterDefaultOn extends InfoSetterTemplate<StorextInfo> {
	
	@Override protected StorextInfo setAttrHook(StorextInfo recordInfo) {	
		recordInfo.isDefault = true;
		return recordInfo;
	}
}
