package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class AddresnapMergerCuslis extends InfoMergerTemplate_<AddresnapInfo, CuslisInfo>{

	@Override protected InfoMergerVisitor_<AddresnapInfo, CuslisInfo> getVisitorHook() {
		return new AddresnapVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
