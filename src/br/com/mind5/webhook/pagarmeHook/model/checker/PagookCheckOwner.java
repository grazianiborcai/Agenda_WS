package br.com.mind5.webhook.pagarmeHook.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;

public final class PagookCheckOwner extends ModelCheckerTemplateForward<PagookInfo, OwnerInfo> {
	
	public PagookCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(PagookInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
