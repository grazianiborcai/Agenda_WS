package br.com.mind5.business.materialStore.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class MatoreUniquifier implements InfoUniquifier<MatoreInfo> {
	
	@Override public List<MatoreInfo> uniquify(List<MatoreInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
