package br.com.mind5.business.order.info;

import br.com.mind5.business.masterData.info.common.FeeCateg;
import br.com.mind5.info.InfoSetterTemplate;

public final class OrderSetterFeeCateg extends InfoSetterTemplate<OrderInfo> {
	
	@Override protected OrderInfo setAttrHook(OrderInfo recordInfo) {
		recordInfo.codFeeCateg = FeeCateg.SERVICE.getCodCateg();
		return recordInfo;
	}	
}
