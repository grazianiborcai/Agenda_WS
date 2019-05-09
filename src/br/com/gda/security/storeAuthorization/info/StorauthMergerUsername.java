package br.com.gda.security.storeAuthorization.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.security.username.info.UsernameInfo;

final class StorauthMergerUsername extends InfoMergerTemplate<StorauthInfo, UsernameInfo> {

	@Override protected InfoMergerVisitorV2<StorauthInfo, UsernameInfo> getVisitorHook() {
		return new StorauthVisiMergeUsername();
	}
}
