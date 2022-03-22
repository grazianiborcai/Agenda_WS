package br.com.mind5.bot.botStats.botStatsCustomer.model.checker;

import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class BostusCheckOwner extends ModelCheckerTemplateForward<BostusInfo, OwnerInfo> {
	
	public BostusCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(BostusInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
