package br.com.gda.business.materialStore.info;

import java.util.List;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoWriterFactory;


public final class MatStoreMerger extends InfoWriterFactory<MatStoreInfo> {	
	static public MatStoreInfo merge(MatInfo sourceOne, MatStoreInfo sourceTwo) {
		return new MatStoreMergerMat().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<MatStoreInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof MatInfo 	&&
			sourceTwos.get(0) instanceof MatStoreInfo		)
			return new MatStoreMergerMat().merge((List<MatInfo>) sourceOnes, (List<MatStoreInfo>) sourceTwos);
		
		return null;
	}
}
