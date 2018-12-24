package br.com.gda.business.materialSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class MatSnapUniquifier implements InfoUniquifier<MatSnapInfo> {
	
	@Override public List<MatSnapInfo> uniquify(List<MatSnapInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
