package br.com.mind5.business.materialStore.model.checker;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatoreCheckLangu extends ModelCheckerTemplateForwardV2<MatoreInfo, LanguInfo> {
	
	public MatoreCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(MatoreInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
