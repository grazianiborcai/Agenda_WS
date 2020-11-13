package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.masterData.timezone.model.checker.TimezoneCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StoreCheckTimezone extends ModelCheckerTemplateForward<StoreInfo, TimezoneInfo> {
	
	public StoreCheckTimezone(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<TimezoneInfo> getCheckerHook(ModelCheckerOption option) {
		return new TimezoneCheckExist(option);
	}
	
	
	
	@Override protected TimezoneInfo toForwardClass(StoreInfo baseRecord) {
		return TimezoneInfo.copyFrom(baseRecord);
	}
}
