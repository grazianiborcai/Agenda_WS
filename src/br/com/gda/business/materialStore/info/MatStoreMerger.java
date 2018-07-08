package br.com.gda.business.materialStore.info;

import java.util.List;
import br.com.gda.business.material.info.MatInfo;

public final class MatStoreMerger {	
	static public MatStoreInfo merge(MatInfo sourceOne, MatStoreInfo sourceTwo) {
		return new MatStoreMergerMat().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public List<MatStoreInfo> merge(List<MatInfo> sourceOnes, List<MatStoreInfo> sourceTwos) {
		return new MatStoreMergerMat().merge(sourceOnes, sourceTwos);
	}
}
