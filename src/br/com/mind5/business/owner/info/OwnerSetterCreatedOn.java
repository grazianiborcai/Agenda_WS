package br.com.mind5.business.owner.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class OwnerSetterCreatedOn extends InfoSetterTemplate<OwnerInfo> {
	
	@Override protected OwnerInfo setAttrHook(OwnerInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
