package br.com.mind5.security.userAuthentication.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class UauthUniquifier implements InfoUniquifier<UauthInfo> {
	
	@Override public List<UauthInfo> uniquify(List<UauthInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
