package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.planingDataSearch.info.PlanarchCopier;
import br.com.mind5.business.planingDataSearch.info.PlanarchInfo;
import br.com.mind5.business.planingDataSearch.model.checker.PlanarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CartemCheckPlanarch extends ModelCheckerTemplateForward<CartemInfo, PlanarchInfo> {
	
	public CartemCheckPlanarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PlanarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PlanarchCheckExist(option);
	}
	
	
	
	@Override protected PlanarchInfo toForwardClass(CartemInfo baseRecord) {
		return PlanarchCopier.copyFromCartem(baseRecord);
	}
}
