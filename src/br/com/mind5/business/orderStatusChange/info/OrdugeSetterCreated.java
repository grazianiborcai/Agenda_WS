package br.com.mind5.business.orderStatusChange.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.orderStatus.info.Orderatus;

public final class OrdugeSetterCreated extends InfoSetterTemplate<OrdugeInfo> {
	
	@Override protected OrdugeInfo setAttrHook(OrdugeInfo recordInfo) {
		recordInfo.codOrderStatusNew = Orderatus.CREATED.getCodStatus();
		return recordInfo;
	}
}
