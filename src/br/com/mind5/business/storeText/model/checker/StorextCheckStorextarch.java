package br.com.mind5.business.storeText.model.checker;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeTextSearch.info.StorextarchCopier;
import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.business.storeTextSearch.model.checker.StorextarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StorextCheckStorextarch extends ModelCheckerTemplateForward<StorextInfo, StorextarchInfo> {
	
	public StorextCheckStorextarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StorextarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new StorextarchCheckExist(option);
	}
	
	
	
	@Override protected StorextarchInfo toForwardClass(StorextInfo baseRecord) {
		return StorextarchCopier.copyFromStorext(baseRecord);
	}
}
