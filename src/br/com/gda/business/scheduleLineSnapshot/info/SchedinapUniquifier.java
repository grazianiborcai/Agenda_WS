package br.com.gda.business.scheduleLineSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class SchedinapUniquifier implements InfoUniquifier<SchedinapInfo> {
	
	@Override public List<SchedinapInfo> uniquify(List<SchedinapInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
