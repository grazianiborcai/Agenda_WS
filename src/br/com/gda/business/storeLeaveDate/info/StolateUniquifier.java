package br.com.gda.business.storeLeaveDate.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class StolevateUniquifier implements InfoUniquifier<StolevateInfo> {
	
	@Override public List<StolevateInfo> uniquify(List<StolevateInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
