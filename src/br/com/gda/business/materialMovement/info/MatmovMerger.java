package br.com.gda.business.materialMovement.info;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.security.username.info.UsernameInfo;

public final class MatmovMerger extends InfoWritterFactory_<MatmovInfo> {	
	
	public MatmovMerger() {
		super(new MatmovUniquifier());
	}
	
	
	
	static public MatmovInfo merge(UsernameInfo sourceOne, MatmovInfo sourceTwo) {
		return new MatmovMergerUsername().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public MatmovInfo merge(MatmovInfo sourceOne, MatmovInfo sourceTwo) {
		return new MatmovMergerToDelete().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public MatmovInfo merge(MatInfo sourceOne, MatmovInfo sourceTwo) {
		return new MatmovMergerMat().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<MatmovInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {			
		if (sourceOnes.get(0) instanceof UsernameInfo 	&&
			sourceTwos.get(0) instanceof MatmovInfo		)
			return new MatmovMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<MatmovInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof MatmovInfo 	&&
			sourceTwos.get(0) instanceof MatmovInfo		)
			return new MatmovMergerToDelete().merge((List<MatmovInfo>) sourceOnes, (List<MatmovInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof MatInfo 		&&
			sourceTwos.get(0) instanceof MatmovInfo		)
			return new MatmovMergerMat().merge((List<MatInfo>) sourceOnes, (List<MatmovInfo>) sourceTwos);	
		
		return null;
	}
}
