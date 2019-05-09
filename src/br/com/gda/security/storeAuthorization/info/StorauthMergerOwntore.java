package br.com.gda.security.storeAuthorization.info;

import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;

final class StorauthMergerOwntore extends InfoMergerTemplate<StorauthInfo, OwntoreInfo> {

	@Override protected InfoMergerVisitorV2<StorauthInfo, OwntoreInfo> getVisitorHook() {
		return new StorauthVisiMergeOwntore();
	}
}
