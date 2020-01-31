package br.com.mind5.security.user.info;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UserMergerFimist extends InfoMergerTemplate_<UserInfo, FimistInfo> {

	@Override protected InfoMergerVisitor_<UserInfo, FimistInfo> getVisitorHook() {
		return new UserVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
