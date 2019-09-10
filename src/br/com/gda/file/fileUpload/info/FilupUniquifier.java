package br.com.gda.file.fileUpload.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class FilupUniquifier implements InfoUniquifier<FilupInfo> {
	
	@Override public List<FilupInfo> uniquify(List<FilupInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
