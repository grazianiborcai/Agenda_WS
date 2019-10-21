package br.com.mind5.file.fileImageSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class FimarchUniquifier implements InfoUniquifier<FimarchInfo> {
	
	@Override public List<FimarchInfo> uniquify(List<FimarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
