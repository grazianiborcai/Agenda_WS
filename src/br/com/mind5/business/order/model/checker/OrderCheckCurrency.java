package br.com.mind5.business.order.model.checker;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.currency.model.checker.CurrencyCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class OrderCheckCurrency extends ModelCheckerTemplateForwardV2<OrderInfo, CurrencyInfo> {
	
	public OrderCheckCurrency(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CurrencyInfo> getCheckerHook(ModelCheckerOption option) {
		return new CurrencyCheckExist(option);
	}
	
	
	
	@Override protected CurrencyInfo toForwardClass(OrderInfo baseRecord) {
		return CurrencyInfo.copyFrom(baseRecord);
	}
}
