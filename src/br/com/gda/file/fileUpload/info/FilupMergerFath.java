package br.com.gda.file.fileUpload.info;

import br.com.gda.file.filePath.info.FathInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class FilupMergerFath extends InfoMergerTemplate<FilupInfo, FathInfo> {

	@Override protected InfoMergerVisitor<FilupInfo, FathInfo> getVisitorHook() {
		return new FilupVisiMergeFath();
	}
	
	
	
	@Override protected InfoUniquifier<FilupInfo> getUniquifierHook() {
		return new FilupUniquifier();
	}
}
