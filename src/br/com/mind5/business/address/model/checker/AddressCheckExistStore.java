package br.com.mind5.business.address.model.checker;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.model.checker.AddarchCheckExistStore;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class AddressCheckExistStore extends ModelCheckerTemplateForward<AddressInfo, AddarchInfo> {
	
	public AddressCheckExistStore(ModelCheckerOption option) {
		super(option);
	}

	

	@Override protected ModelChecker<AddarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new AddarchCheckExistStore(option);
	}
	
	
	
	@Override protected AddarchInfo toForwardClass(AddressInfo baseRecord) {
		return AddarchInfo.copyFrom(baseRecord);
	}
}
