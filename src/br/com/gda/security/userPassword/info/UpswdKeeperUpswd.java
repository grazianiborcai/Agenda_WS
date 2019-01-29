package br.com.gda.security.userPassword.info;

import java.util.List;

import br.com.gda.info.InfoKeeper;

final class UpswdKeeperUpswd extends InfoKeeper<UpswdInfo, UpswdInfo> {
	public UpswdInfo keep(UpswdInfo sourceOne, UpswdInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UpswdVisiKeepUpswd());
	}
	
	
	
	public List<UpswdInfo> keep(List<UpswdInfo> sourceOnes, List<UpswdInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UpswdVisiKeepUpswd());
	}
}
