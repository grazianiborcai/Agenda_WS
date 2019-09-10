package br.com.gda.file.fileUpload.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class FilupMergerUsername extends InfoMergerTemplate<FilupInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<FilupInfo, UsernameInfo> getVisitorHook() {
		return new FilupVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<FilupInfo> getUniquifierHook() {
		return new FilupUniquifier();
	}
}
