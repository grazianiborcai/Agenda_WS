package br.com.mind5.business.materialStore.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class MatoreSetterCreatedOn extends InfoSetterTemplate<MatoreInfo> {
	
	@Override protected MatoreInfo setAttrHook(MatoreInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
