package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.masterData.timezone.model.checker.TimezoneCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class StoreCheckTimezone extends ModelCheckerTemplateForwardV2<StoreInfo, TimezoneInfo> {
	
	public StoreCheckTimezone(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<TimezoneInfo> getCheckerHook(ModelCheckerOption option) {
		return new TimezoneCheckExist(option);
	}
	
	
	
	@Override protected TimezoneInfo toForwardClass(StoreInfo baseRecord) {
		return TimezoneInfo.copyFrom(baseRecord);
	}
}
