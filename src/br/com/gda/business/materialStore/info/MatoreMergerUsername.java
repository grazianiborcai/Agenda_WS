package br.com.gda.business.materialStore.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.security.username.info.UsernameInfo;

final class MatoreMergerUsername extends InfoMergerTemplate<MatoreInfo, UsernameInfo> {

	@Override protected InfoMergerVisitorV2<MatoreInfo, UsernameInfo> getVisitorHook() {
		return new MatoreVisiMergeUsername();
	}
}
