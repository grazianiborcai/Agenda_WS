package br.com.gda.security.storeAuthorization.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class StorauthUniquifier implements InfoUniquifier<StorauthInfo> {
	
	@Override public List<StorauthInfo> uniquify(List<StorauthInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
