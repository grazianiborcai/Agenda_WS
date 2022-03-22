package br.com.mind5.bot.botStats.botStatsCustomer.model.checker;

import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusInfo;
import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.checker.CusCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class BostusCheckCus extends ModelCheckerTemplateForward<BostusInfo, CusInfo> {
	
	public BostusCheckCus(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CusInfo> getCheckerHook(ModelCheckerOption option) {
		return new CusCheckExist(option);
	}
	
	
	
	@Override protected CusInfo toForwardClass(BostusInfo baseRecord) {
		return CusInfo.copyFrom(baseRecord);
	}
}
