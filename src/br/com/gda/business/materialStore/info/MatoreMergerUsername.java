package br.com.gda.business.materialStore.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.security.username.info.UsernameInfo;

final class MatoreMergerUsername extends InfoMergerTemplate<MatoreInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<MatoreInfo, UsernameInfo> getVisitorHook() {
		return new MatoreVisiMergeUsername();
	}
}
