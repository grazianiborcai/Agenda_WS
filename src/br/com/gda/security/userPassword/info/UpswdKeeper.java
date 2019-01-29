package br.com.gda.security.userPassword.info;

import java.util.List;

import br.com.gda.info.InfoWritterFactory;

public final class UpswdKeeper extends InfoWritterFactory<UpswdInfo> {	
	
	public UpswdKeeper() {
		super(new UpswdUniquifier());
	}
	
	
	
	@Override protected boolean isKeeperHook() {
		return super.ENABLED;
	}
	
	
	
	static public UpswdInfo keep(UpswdInfo sourceOne, UpswdInfo sourceTwo) {
		return new UpswdKeeperUpswd().keep(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<UpswdInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof UpswdInfo 	&&
			sourceTwos.get(0) instanceof UpswdInfo		)
			return new UpswdKeeperUpswd().keep((List<UpswdInfo>) sourceOnes, (List<UpswdInfo>) sourceTwos);
		
		
		return null;
	}
}
