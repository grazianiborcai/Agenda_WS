package br.com.mind5.security.user.info;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UserMergerFimist extends InfoMergerTemplate<UserInfo, FimistInfo> {

	@Override protected InfoMergerVisitor<UserInfo, FimistInfo> getVisitorHook() {
		return new UserVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
