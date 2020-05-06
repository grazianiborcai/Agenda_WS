package br.com.mind5.business.refundPolicyStore.model.checker;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporerchInfo;
import br.com.mind5.business.refundPolicyStoreSearch.model.checker.RefuporerchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class RefuporeCheckRefuporerch extends ModelCheckerTemplateForwardV2<RefuporeInfo, RefuporerchInfo> {
	
	public RefuporeCheckRefuporerch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<RefuporerchInfo> getCheckerHook(ModelCheckerOption option) {
		return new RefuporerchCheckExist(option);
	}
	
	
	
	@Override protected RefuporerchInfo toForwardClass(RefuporeInfo baseRecord) {
		return RefuporerchInfo.copyFrom(baseRecord);
	}
}
