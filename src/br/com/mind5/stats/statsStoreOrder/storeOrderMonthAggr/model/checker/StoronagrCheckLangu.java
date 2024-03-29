package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;

public final class StoronagrCheckLangu extends ModelCheckerTemplateForward<StoronagrInfo, LanguInfo> {
	
	public StoronagrCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(StoronagrInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
