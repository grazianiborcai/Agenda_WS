package br.com.gda.security.storeAuthorization.info;

import java.util.List;

import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.security.username.info.UsernameInfo;

public final class StorauthMerger extends InfoWritterFactory<StorauthInfo> {	
	
	public StorauthMerger() {
		super();
	}
	
	
	
	static public StorauthInfo merge(UsernameInfo sourceOne, StorauthInfo sourceTwo) {
		return new StorauthMergerUsername().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public StorauthInfo merge(OwntoreInfo sourceOne, StorauthInfo sourceTwo) {
		return new StorauthMergerOwntore().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<StorauthInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof UsernameInfo 	&&
			sourceTwos.get(0) instanceof StorauthInfo		)
			return new StorauthMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<StorauthInfo>) sourceTwos);		
		
		
		if (sourceOnes.get(0) instanceof OwntoreInfo 	&&
			sourceTwos.get(0) instanceof StorauthInfo		)
			return new StorauthMergerOwntore().merge((List<OwntoreInfo>) sourceOnes, (List<StorauthInfo>) sourceTwos);	
		
		return null;
	}
}
