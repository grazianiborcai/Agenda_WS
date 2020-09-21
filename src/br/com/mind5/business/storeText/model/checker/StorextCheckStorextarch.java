package br.com.mind5.business.storeText.model.checker;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeTextSearch.info.StorextarchCopier;
import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.business.storeTextSearch.model.checker.StorextarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class StorextCheckStorextarch extends ModelCheckerTemplateForwardV2<StorextInfo, StorextarchInfo> {
	
	public StorextCheckStorextarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StorextarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new StorextarchCheckExist(option);
	}
	
	
	
	@Override protected StorextarchInfo toForwardClass(StorextInfo baseRecord) {
		return StorextarchCopier.copyFromStorext(baseRecord);
	}
}
