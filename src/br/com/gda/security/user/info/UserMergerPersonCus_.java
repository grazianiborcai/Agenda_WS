package br.com.gda.security.user.info;

import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class UserMergerPersonCus_ extends InfoMergerTemplate<UserInfo, PersonCusInfo> {

	@Override protected InfoMergerVisitor<UserInfo, PersonCusInfo> getVisitorHook() {
		return new UserVisiMergePersonCus_();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
