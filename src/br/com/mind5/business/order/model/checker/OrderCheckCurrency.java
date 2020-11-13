package br.com.mind5.business.order.model.checker;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.currency.model.checker.CurrencyCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OrderCheckCurrency extends ModelCheckerTemplateForward<OrderInfo, CurrencyInfo> {
	
	public OrderCheckCurrency(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CurrencyInfo> getCheckerHook(ModelCheckerOption option) {
		return new CurrencyCheckExist(option);
	}
	
	
	
	@Override protected CurrencyInfo toForwardClass(OrderInfo baseRecord) {
		return CurrencyInfo.copyFrom(baseRecord);
	}
}
