package br.com.mind5.businessContent.material.main.model.checker;

import br.com.mind5.businessContent.material.main.info.MatbcinInfo;
import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.checker.SytotinCheckEnabled;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatbcinCheckSytotin extends ModelCheckerTemplateForwardV2<MatbcinInfo, SytotinInfo> {
	
	public MatbcinCheckSytotin(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<SytotinInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotinCheckEnabled(option);
	}
	
	
	
	@Override protected SytotinInfo toForwardClass(MatbcinInfo baseRecord) {
		return SytotinInfo.copyFrom(baseRecord);
	}
}
