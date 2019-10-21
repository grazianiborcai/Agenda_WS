package br.com.mind5.file.fileImageList.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class FimistUniquifier implements InfoUniquifier<FimistInfo> {
	
	@Override public List<FimistInfo> uniquify(List<FimistInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
