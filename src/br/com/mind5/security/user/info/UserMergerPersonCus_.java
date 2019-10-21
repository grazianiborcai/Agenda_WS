package br.com.mind5.security.user.info;

import br.com.mind5.business.personCustomer.info.PersonCusInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UserMergerPersonCus_ extends InfoMergerTemplate<UserInfo, PersonCusInfo> {

	@Override protected InfoMergerVisitor<UserInfo, PersonCusInfo> getVisitorHook() {
		return new UserVisiMergePersonCus_();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
