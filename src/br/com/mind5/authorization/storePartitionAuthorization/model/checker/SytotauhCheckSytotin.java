package br.com.mind5.authorization.storePartitionAuthorization.model.checker;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.checker.SytotinCheckEnabled;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SytotauhCheckSytotin extends ModelCheckerTemplateForward<SytotauhInfo, SytotinInfo> {
	
	public SytotauhCheckSytotin(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SytotinInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotinCheckEnabled(option);
	}
	
	
	
	@Override protected SytotinInfo toForwardClass(SytotauhInfo baseRecord) {
		return SytotinInfo.copyFrom(baseRecord);
	}
}
