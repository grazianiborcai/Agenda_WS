package br.com.mind5.business.materialTextSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class MatextsnapUniquifier implements InfoUniquifier<MatextsnapInfo> {
	
	@Override public List<MatextsnapInfo> uniquify(List<MatextsnapInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
