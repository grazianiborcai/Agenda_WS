package br.com.mind5.security.storeAuthorization.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class StorauthUniquifier implements InfoUniquifier<StorauthInfo> {
	
	@Override public List<StorauthInfo> uniquify(List<StorauthInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
