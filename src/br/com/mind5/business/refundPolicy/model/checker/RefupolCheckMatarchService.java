package br.com.mind5.business.refundPolicy.model.checker;

import br.com.mind5.business.materialSearch.info.MatarchCopier;
import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.checker.MatarchCheckExistService;
import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class RefupolCheckMatarchService extends ModelCheckerTemplateForward<RefupolInfo, MatarchInfo> {
	
	public RefupolCheckMatarchService(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatarchCheckExistService(option);
	}
	
	
	
	@Override protected MatarchInfo toForwardClass(RefupolInfo baseRecord) {
		return MatarchCopier.copyFromRefupol(baseRecord);
	}
}
