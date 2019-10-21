package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class AddresnapMergerCuslis extends InfoMergerTemplate<AddresnapInfo, CuslisInfo>{

	@Override protected InfoMergerVisitor<AddresnapInfo, CuslisInfo> getVisitorHook() {
		return new AddresnapVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
