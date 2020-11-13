package br.com.mind5.business.materialMovement.model.checker;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.checker.MatarchCheckExistProduct;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatmovCheckMatarchProduct extends ModelCheckerTemplateForward<MatmovInfo, MatarchInfo> {
	
	public MatmovCheckMatarchProduct(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatarchCheckExistProduct(option);
	}
	
	
	
	@Override protected MatarchInfo toForwardClass(MatmovInfo baseRecord) {
		return MatarchInfo.copyFrom(baseRecord);
	}
}
