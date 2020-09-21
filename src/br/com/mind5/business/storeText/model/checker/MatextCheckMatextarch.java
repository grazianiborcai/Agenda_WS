package br.com.mind5.business.storeText.model.checker;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.materialTextSearch.info.MatextarchCopier;
import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.business.materialTextSearch.model.checker.MatextarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatextCheckMatextarch extends ModelCheckerTemplateForwardV2<StorextInfo, MatextarchInfo> {
	
	public MatextCheckMatextarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MatextarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatextarchCheckExist(option);
	}
	
	
	
	@Override protected MatextarchInfo toForwardClass(StorextInfo baseRecord) {
		return MatextarchCopier.copyFromMatext(baseRecord);
	}
}
