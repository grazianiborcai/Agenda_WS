package br.com.gda.file.fileUpload.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class FilupMergerToSelect extends InfoMergerTemplate<FilupInfo, FilupInfo> {

	@Override protected InfoMergerVisitor<FilupInfo, FilupInfo> getVisitorHook() {
		return new FilupVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<FilupInfo> getUniquifierHook() {
		return new FilupUniquifier();
	}
}
