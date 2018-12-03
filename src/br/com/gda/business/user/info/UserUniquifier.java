package br.com.gda.business.user.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class UserUniquifier implements InfoUniquifier<UserInfo> {
	
	@Override public List<UserInfo> uniquify(List<UserInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
