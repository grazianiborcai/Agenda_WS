package br.com.mind5.business.personSearch.model.checker;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.checker.SytotinCheckEnabled;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class PerarchCheckSytotin extends ModelCheckerTemplateForward<PerarchInfo, SytotinInfo> {
	
	public PerarchCheckSytotin(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SytotinInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotinCheckEnabled(option);
	}
	
	
	
	@Override protected SytotinInfo toForwardClass(PerarchInfo baseRecord) {
		return SytotinInfo.copyFrom(baseRecord);
	}
}
