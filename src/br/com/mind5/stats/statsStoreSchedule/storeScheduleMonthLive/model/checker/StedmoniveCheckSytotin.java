package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.checker;

import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.checker.SytotinCheckEnabled;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;

public final class StedmoniveCheckSytotin extends ModelCheckerTemplateForward<StedmoniveInfo, SytotinInfo> {
	
	public StedmoniveCheckSytotin(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SytotinInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotinCheckEnabled(option);
	}
	
	
	
	@Override protected SytotinInfo toForwardClass(StedmoniveInfo baseRecord) {
		return SytotinInfo.copyFrom(baseRecord);
	}
}
