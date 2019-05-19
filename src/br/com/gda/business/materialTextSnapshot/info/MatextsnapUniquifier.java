package br.com.gda.business.materialTextSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class MatextsnapUniquifier implements InfoUniquifier<MatextsnapInfo> {
	
	@Override public List<MatextsnapInfo> uniquify(List<MatextsnapInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
