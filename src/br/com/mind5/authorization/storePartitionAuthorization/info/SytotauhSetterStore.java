package br.com.mind5.authorization.storePartitionAuthorization.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SytotauhSetterStore extends InfoSetterTemplate<SytotauhInfo> {
	
	@Override protected SytotauhInfo setAttrHook(SytotauhInfo recordInfo) {
		recordInfo.codStore = DefaultValue.number();		
		return recordInfo;
	}
}
