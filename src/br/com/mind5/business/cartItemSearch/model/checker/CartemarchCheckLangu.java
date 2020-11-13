package br.com.mind5.business.cartItemSearch.model.checker;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CartemarchCheckLangu extends ModelCheckerTemplateForward<CartemarchInfo, LanguInfo> {
	
	public CartemarchCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(CartemarchInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
