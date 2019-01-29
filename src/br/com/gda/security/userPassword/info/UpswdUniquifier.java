package br.com.gda.security.userPassword.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class UpswdUniquifier implements InfoUniquifier<UpswdInfo> {
	
	@Override public List<UpswdInfo> uniquify(List<UpswdInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
