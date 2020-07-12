package br.com.mind5.business.personSearch.model.checker;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.checker.SytotinCheckEnabled;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class PerarchCheckSytotin extends ModelCheckerTemplateForwardV2<PerarchInfo, SytotinInfo> {
	
	public PerarchCheckSytotin(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<SytotinInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotinCheckEnabled(option);
	}
	
	
	
	@Override protected SytotinInfo toForwardClass(PerarchInfo baseRecord) {
		return SytotinInfo.copyFrom(baseRecord);
	}
}
