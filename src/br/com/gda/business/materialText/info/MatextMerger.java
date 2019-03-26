package br.com.gda.business.materialText.info;

import java.util.List;

import br.com.gda.info.InfoWritterFactory;
import br.com.gda.security.username.info.UsernameInfo;

public final class MatextMerger extends InfoWritterFactory<MatextInfo> {	
	
	public MatextMerger() {
		super(new MatextUniquifier());
	}
	
	
	
	static public MatextInfo merge(UsernameInfo sourceOne, MatextInfo sourceTwo) {
		return new MatextMergerUsername().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public MatextInfo merge(MatextInfo sourceOne, MatextInfo sourceTwo) {
		return new MatextMergerToDelete().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<MatextInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof UsernameInfo 	&&
			sourceTwos.get(0) instanceof MatextInfo		)
			return new MatextMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<MatextInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof MatextInfo	 	&&
			sourceTwos.get(0) instanceof MatextInfo		)
			return new MatextMergerToDelete().merge((List<MatextInfo>) sourceOnes, (List<MatextInfo>) sourceTwos);
		
		
		return null;
	}
}
