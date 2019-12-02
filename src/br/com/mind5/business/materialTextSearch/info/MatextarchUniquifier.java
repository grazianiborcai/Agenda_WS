package br.com.mind5.business.materialTextSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class MatextarchUniquifier implements InfoUniquifier<MatextarchInfo> {
	
	@Override public List<MatextarchInfo> uniquify(List<MatextarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
