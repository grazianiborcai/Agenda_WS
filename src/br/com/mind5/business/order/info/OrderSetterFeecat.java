package br.com.mind5.business.order.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.feeCategory.info.Feecat;

public final class OrderSetterFeecat extends InfoSetterTemplate<OrderInfo> {
	
	@Override protected OrderInfo setAttrHook(OrderInfo recordInfo) {
		recordInfo.codFeeCateg = Feecat.SERVICE.getCodCateg();
		return recordInfo;
	}	
}
