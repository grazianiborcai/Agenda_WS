package br.com.mind5.businessContent.material.main.model.checker;

import br.com.mind5.businessContent.material.main.info.MatbcinInfo;
import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.checker.SytotinCheckEnabled;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatbcinCheckSytotin extends ModelCheckerTemplateForward<MatbcinInfo, SytotinInfo> {
	
	public MatbcinCheckSytotin(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SytotinInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotinCheckEnabled(option);
	}
	
	
	
	@Override protected SytotinInfo toForwardClass(MatbcinInfo baseRecord) {
		return SytotinInfo.copyFrom(baseRecord);
	}
}
