package br.com.mind5.business.materialStoreSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class MatorapUniquifier implements InfoUniquifier<MatorapInfo> {
	
	@Override public List<MatorapInfo> uniquify(List<MatorapInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
