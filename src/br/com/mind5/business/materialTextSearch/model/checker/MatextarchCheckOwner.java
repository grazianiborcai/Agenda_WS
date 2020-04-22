package br.com.mind5.business.materialTextSearch.model.checker;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatextarchCheckOwner extends ModelCheckerTemplateForwardV2<MatextarchInfo, OwnerInfo> {
	
	public MatextarchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(MatextarchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
