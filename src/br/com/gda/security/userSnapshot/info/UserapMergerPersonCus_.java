package br.com.gda.security.userSnapshot.info;

import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class UserapMergerPersonCus_ extends InfoMergerTemplate<UserapInfo, PersonCusInfo> {

	@Override protected InfoMergerVisitor<UserapInfo, PersonCusInfo> getVisitorHook() {
		return new UserapVisiMergePersonCus_();
	}
	
	
	
	@Override protected InfoUniquifier<UserapInfo> getUniquifierHook() {
		return new UserapUniquifier();
	}
}
