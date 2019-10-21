package br.com.mind5.file.fileImage.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class FimgUniquifier implements InfoUniquifier<FimgInfo> {
	
	@Override public List<FimgInfo> uniquify(List<FimgInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
