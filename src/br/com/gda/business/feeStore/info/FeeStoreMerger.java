package br.com.gda.business.feeStore.info;

import java.util.List;

import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoWriterFactory;

public final class FeeStoreMerger extends InfoWriterFactory<FeeStoreInfo> {	
	
	public FeeStoreMerger() {
		super();
	}
	
	
	
	static public FeeStoreInfo merge(StoreInfo sourceOne, FeeStoreInfo sourceTwo) {
		return new FeeStoreMergerStore().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<FeeStoreInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof StoreInfo 	&&
			sourceTwos.get(0) instanceof FeeStoreInfo		)
			return new FeeStoreMergerStore().merge((List<StoreInfo>) sourceOnes, (List<FeeStoreInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof FeeDefaultInfo 	&&
			sourceTwos.get(0) instanceof FeeStoreInfo		)
			return new FeeStoreMergerDefault().merge((List<FeeDefaultInfo>) sourceOnes, (List<FeeStoreInfo>) sourceTwos);
		
		return null;
	}
}
