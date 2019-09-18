package br.com.gda.business.addressSnapshot.info;

import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

public final class AddresnapMergerCuslis extends InfoMergerTemplate<AddresnapInfo, CuslisInfo>{

	@Override protected InfoMergerVisitor<AddresnapInfo, CuslisInfo> getVisitorHook() {
		return new AddresnapVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
