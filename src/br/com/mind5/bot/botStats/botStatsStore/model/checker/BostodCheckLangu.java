package br.com.mind5.bot.botStats.botStatsStore.model.checker;

import br.com.mind5.bot.botStats.botStatsStore.info.BostodInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class BostodCheckLangu extends ModelCheckerTemplateForward<BostodInfo, LanguInfo> {
	
	public BostodCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(BostodInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
