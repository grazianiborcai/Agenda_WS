package br.com.mind5.business.storeTextSnapshot.model.checker;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.checker.StorextCheckExist;
import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class StorextsnapCheckStorext extends ModelCheckerTemplateForwardV2<StorextsnapInfo, StorextInfo> {
	
	public StorextsnapCheckStorext(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StorextInfo> getCheckerHook(ModelCheckerOption option) {
		return new StorextCheckExist(option);
	}
	
	
	
	@Override protected StorextInfo toForwardClass(StorextsnapInfo baseRecord) {
		return StorextInfo.copyFrom(baseRecord);
	}
}
