package br.com.mind5.businessContent.material.main.model.checker;

import br.com.mind5.businessContent.material.main.info.MatbcinInfo;
import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcInfo;
import br.com.mind5.config.sysStoreBusinessContent.model.checker.SytorbcCheckEnabled;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatbcinCheckSytorbc extends ModelCheckerTemplateForwardV2<MatbcinInfo, SytorbcInfo> {
	
	public MatbcinCheckSytorbc(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<SytorbcInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytorbcCheckEnabled(option);
	}
	
	
	
	@Override protected SytorbcInfo toForwardClass(MatbcinInfo baseRecord) {
		return SytorbcInfo.copyFrom(baseRecord);
	}
}
