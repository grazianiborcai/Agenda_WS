package br.com.mind5.business.addressSearch.model.checker;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.masterData.info.LanguInfo;
import br.com.mind5.business.masterData.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class AddarchCheckLangu extends ModelCheckerTemplateForwardV2<AddarchInfo, LanguInfo> {
	
	public AddarchCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(AddarchInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
