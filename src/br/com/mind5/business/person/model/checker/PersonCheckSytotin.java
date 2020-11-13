package br.com.mind5.business.person.model.checker;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.checker.SytotinCheckEnabled;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class PersonCheckSytotin extends ModelCheckerTemplateForward<PersonInfo, SytotinInfo> {
	
	public PersonCheckSytotin(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SytotinInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotinCheckEnabled(option);
	}
	
	
	
	@Override protected SytotinInfo toForwardClass(PersonInfo baseRecord) {
		return SytotinInfo.copyFrom(baseRecord);
	}
}
