package br.com.mind5.business.materialList.model.checker;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistCustomer;

public final class MatlisCheckAuthCustomer extends ModelCheckerTemplateForwardV2<MatlisInfo, UserarchInfo> {
	
	public MatlisCheckAuthCustomer(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistCustomer(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(MatlisInfo baseRecord) {
		return UserarchInfo.copyFrom(baseRecord);
	}
}
