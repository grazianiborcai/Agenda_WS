package br.com.mind5.stats.userStore.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.userStore.info.StusoreInfo;
import br.com.mind5.stats.userStoreAggr.info.StusoraggInfo;
import br.com.mind5.stats.userStoreAggr.model.checker.StusoraggCheckExist;

public final class StusoreCheckStusoragg extends ModelCheckerTemplateForward<StusoreInfo, StusoraggInfo> {
	
	public StusoreCheckStusoragg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StusoraggInfo> getCheckerHook(ModelCheckerOption option) {
		return new StusoraggCheckExist(option);
	}
	
	
	
	@Override protected StusoraggInfo toForwardClass(StusoreInfo baseRecord) {
		return StusoraggInfo.copyFrom(baseRecord);
	}
}
