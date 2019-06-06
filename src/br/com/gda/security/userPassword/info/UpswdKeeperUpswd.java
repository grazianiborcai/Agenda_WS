package br.com.gda.security.userPassword.info;

import java.util.List;

import br.com.gda.info.obsolete.InfoKeeper_;

final class UpswdKeeperUpswd extends InfoKeeper_<UpswdInfo, UpswdInfo> {
	public UpswdInfo keep(UpswdInfo sourceOne, UpswdInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UpswdVisiKeepUpswd());
	}
	
	
	
	public List<UpswdInfo> keep(List<UpswdInfo> sourceOnes, List<UpswdInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UpswdVisiKeepUpswd());
	}
}
