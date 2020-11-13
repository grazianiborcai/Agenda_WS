package br.com.mind5.business.materialSearch.model.checker;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.checker.SytotinCheckEnabled;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatarchCheckSytotin extends ModelCheckerTemplateForward<MatarchInfo, SytotinInfo> {
	
	public MatarchCheckSytotin(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SytotinInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotinCheckEnabled(option);
	}
	
	
	
	@Override protected SytotinInfo toForwardClass(MatarchInfo baseRecord) {
		return SytotinInfo.copyFrom(baseRecord);
	}
}
