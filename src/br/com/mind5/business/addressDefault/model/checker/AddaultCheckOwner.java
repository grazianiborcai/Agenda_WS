package br.com.mind5.business.addressDefault.model.checker;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class AddaultCheckOwner extends ModelCheckerTemplateForwardV2<AddaultInfo, OwnerInfo> {
	
	public AddaultCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(AddaultInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
