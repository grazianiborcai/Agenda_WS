package br.com.gda.business.materialText.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class MatextMergerUsername extends InfoMergerTemplate<MatextInfo, UsernameInfo> {

	@Override protected InfoMergerVisitorV2<MatextInfo, UsernameInfo> getVisitorHook() {
		return new MatextVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<MatextInfo> getUniquifierHook() {
		return new MatextUniquifier();
	}
}
