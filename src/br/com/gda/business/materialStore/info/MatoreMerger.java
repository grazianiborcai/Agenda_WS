package br.com.gda.business.materialStore.info;

import java.util.List;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.security.username.info.UsernameInfo;


public final class MatoreMerger extends InfoWritterFactory<MatoreInfo> {	
	static public MatoreInfo merge(MatInfo sourceOne, MatoreInfo sourceTwo) {
		return new MatoreMergerMat().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public MatoreInfo merge(UsernameInfo sourceOne, MatoreInfo sourceTwo) {
		return new MatoreMergerUsername().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public MatoreInfo merge(MatoreInfo sourceOne, MatoreInfo sourceTwo) {
		return new MatoreMergerToDelete().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public MatoreInfo merge(MatockInfo sourceOne, MatoreInfo sourceTwo) {
		return new MatoreMergerMatock().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<MatoreInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof MatInfo 		&&
			sourceTwos.get(0) instanceof MatoreInfo			)
			return new MatoreMergerMat().merge((List<MatInfo>) sourceOnes, (List<MatoreInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof UsernameInfo 	&&
			sourceTwos.get(0) instanceof MatoreInfo			)
			return new MatoreMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<MatoreInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof MatoreInfo 	&&
			sourceTwos.get(0) instanceof MatoreInfo		)
			return new MatoreMergerToDelete().merge((List<MatoreInfo>) sourceOnes, (List<MatoreInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof MatockInfo 	&&
			sourceTwos.get(0) instanceof MatoreInfo			)
			return new MatoreMergerMatock().merge((List<MatockInfo>) sourceOnes, (List<MatoreInfo>) sourceTwos);
		
		return null;
	}
}
