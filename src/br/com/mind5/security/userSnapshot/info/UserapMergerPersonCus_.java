package br.com.mind5.security.userSnapshot.info;

import br.com.mind5.business.personCustomer_.info.PersonCusInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UserapMergerPersonCus_ extends InfoMergerTemplate<UserapInfo, PersonCusInfo> {

	@Override protected InfoMergerVisitor<UserapInfo, PersonCusInfo> getVisitorHook() {
		return new UserapVisiMergePersonCus_();
	}
	
	
	
	@Override protected InfoUniquifier<UserapInfo> getUniquifierHook() {
		return new UserapUniquifier();
	}
}
