package br.com.mind5.business.materialText.model.checker;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialTextSearch.info.MatextarchCopier;
import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.business.materialTextSearch.model.checker.MatextarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatextCheckMatextarch extends ModelCheckerTemplateForwardV2<MatextInfo, MatextarchInfo> {
	
	public MatextCheckMatextarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MatextarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatextarchCheckExist(option);
	}
	
	
	
	@Override protected MatextarchInfo toForwardClass(MatextInfo baseRecord) {
		return MatextarchCopier.copyFromMatext(baseRecord);
	}
}
