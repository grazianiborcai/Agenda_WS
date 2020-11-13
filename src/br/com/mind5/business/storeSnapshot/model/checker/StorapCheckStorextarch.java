package br.com.mind5.business.storeSnapshot.model.checker;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.business.storeTextSearch.model.checker.StorextarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StorapCheckStorextarch extends ModelCheckerTemplateForward<StorapInfo, StorextarchInfo> {
	
	public StorapCheckStorextarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StorextarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new StorextarchCheckExist(option);
	}
	
	
	
	@Override protected StorextarchInfo toForwardClass(StorapInfo baseRecord) {
		return StorextarchInfo.copyFrom(baseRecord);
	}
}
