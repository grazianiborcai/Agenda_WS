package br.com.gda.file.fileUpload.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class FilupMergerToDelete extends InfoMergerTemplate<FilupInfo, FilupInfo> {

	@Override protected InfoMergerVisitor<FilupInfo, FilupInfo> getVisitorHook() {
		return new FilupVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<FilupInfo> getUniquifierHook() {
		return new FilupUniquifier();
	}
}
