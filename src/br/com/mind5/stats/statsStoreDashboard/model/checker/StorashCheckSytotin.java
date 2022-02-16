package br.com.mind5.stats.statsStoreDashboard.model.checker;

import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.checker.SytotinCheckEnabled;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;

public final class StorashCheckSytotin extends ModelCheckerTemplateForward<StorashInfo, SytotinInfo> {
	
	public StorashCheckSytotin(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SytotinInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotinCheckEnabled(option);
	}
	
	
	
	@Override protected SytotinInfo toForwardClass(StorashInfo baseRecord) {
		return SytotinInfo.copyFrom(baseRecord);
	}
}
