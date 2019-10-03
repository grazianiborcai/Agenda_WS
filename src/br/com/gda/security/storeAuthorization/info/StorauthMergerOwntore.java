package br.com.gda.security.storeAuthorization.info;

import br.com.gda.business.ownerStore_.info.OwntoreInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;

final class StorauthMergerOwntore extends InfoMergerTemplate<StorauthInfo, OwntoreInfo> {

	@Override protected InfoMergerVisitor<StorauthInfo, OwntoreInfo> getVisitorHook() {
		return new StorauthVisiMergeOwntore();
	}
}
