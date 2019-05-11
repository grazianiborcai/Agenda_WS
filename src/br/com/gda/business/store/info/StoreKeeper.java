package br.com.gda.business.store.info;

import java.util.List;

import br.com.gda.info.obsolete.InfoWritterFactory_;

public final class StoreKeeper extends InfoWritterFactory_<StoreInfo> {	
	
	public StoreKeeper() {
		super(new StoreUniquifier());
	}
	
	
	
	@Override protected boolean isKeeperHook() {
		return super.ENABLED;
	}
	
	
	
	static public StoreInfo keep(StoreInfo sourceOne, StoreInfo sourceTwo) {
		return new StoreKeeperStore().keep(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<StoreInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof StoreInfo 	&&
			sourceTwos.get(0) instanceof StoreInfo		)
			return new StoreKeeperStore().keep((List<StoreInfo>) sourceOnes, (List<StoreInfo>) sourceTwos);
		
		
		return null;
	}
}
