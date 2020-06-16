package br.com.mind5.business.orderStatusChange.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.orderStatus.info.Orderatus;

public final class OrdugeSetterRefunding extends InfoSetterTemplate<OrdugeInfo> {
	
	@Override protected OrdugeInfo setAttrHook(OrdugeInfo recordInfo) {
		recordInfo.codOrderStatusNew = Orderatus.REFUNDING.getCodStatus();
		return recordInfo;
	}
}
