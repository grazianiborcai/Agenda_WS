package br.com.mind5.bot.botStats.botStatsStore.model.checker;

import br.com.mind5.bot.botStats.botStatsStore.info.BostodInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class BostodCheckOwner extends ModelCheckerTemplateForward<BostodInfo, OwnerInfo> {
	
	public BostodCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(BostodInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
