package br.com.gda.business.materialMovement.info;

import java.util.List;

import br.com.gda.info.InfoWritterFactory;
import br.com.gda.security.username.info.UsernameInfo;

public final class MatmovMerger extends InfoWritterFactory<MatmovInfo> {	
	
	public MatmovMerger() {
		super(new MatmovUniquifier());
	}
	
	
	
	static public MatmovInfo merge(UsernameInfo sourceOne, MatmovInfo sourceTwo) {
		return new MatmovMergerUsername().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public MatmovInfo merge(MatmovInfo sourceOne, MatmovInfo sourceTwo) {
		return new MatmovMergerToDelete().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<MatmovInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {			
		if (sourceOnes.get(0) instanceof UsernameInfo 	&&
			sourceTwos.get(0) instanceof MatmovInfo		)
			return new MatmovMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<MatmovInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof MatmovInfo 	&&
			sourceTwos.get(0) instanceof MatmovInfo		)
			return new MatmovMergerToDelete().merge((List<MatmovInfo>) sourceOnes, (List<MatmovInfo>) sourceTwos);	
		
		return null;
	}
}
