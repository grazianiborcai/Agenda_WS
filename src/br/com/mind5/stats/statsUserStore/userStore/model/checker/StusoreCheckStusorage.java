package br.com.mind5.stats.statsUserStore.userStore.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsUserStore.userStore.info.StusoreInfo;
import br.com.mind5.stats.statsUserStore.userStoreStgn.info.StusorageInfo;
import br.com.mind5.stats.statsUserStore.userStoreStgn.model.checker.StusorageCheckExist;

public final class StusoreCheckStusorage extends ModelCheckerTemplateForward<StusoreInfo, StusorageInfo> {
	
	public StusoreCheckStusorage(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StusorageInfo> getCheckerHook(ModelCheckerOption option) {
		return new StusorageCheckExist(option);
	}
	
	
	
	@Override protected StusorageInfo toForwardClass(StusoreInfo baseRecord) {
		return StusorageInfo.copyFrom(baseRecord);
	}
}
