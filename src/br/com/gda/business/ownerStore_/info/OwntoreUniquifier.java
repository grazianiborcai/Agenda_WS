package br.com.gda.business.ownerStore_.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.business.ownerStore_.info.OwntoreInfo;
import br.com.gda.info.InfoUniquifier;

final class OwntoreUniquifier implements InfoUniquifier<OwntoreInfo> {
	
	@Override public List<OwntoreInfo> uniquify(List<OwntoreInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
