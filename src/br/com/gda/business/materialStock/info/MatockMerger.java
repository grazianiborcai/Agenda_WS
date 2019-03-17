package br.com.gda.business.materialStock.info;

import java.util.List;

import br.com.gda.info.InfoWritterFactory;

public final class MatockMerger extends InfoWritterFactory<MatockInfo> {	
	
	public MatockMerger() {
		super(new MatockUniquifier());
	}
	
	
	
	static public MatockInfo merge(MatockInfo sourceOne, MatockInfo sourceTwo) {
		return new MatockMergerToUpdate().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<MatockInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof MatockInfo 	&&
			sourceTwos.get(0) instanceof MatockInfo		)
			return new MatockMergerToUpdate().merge((List<MatockInfo>) sourceOnes, (List<MatockInfo>) sourceTwos);	
		
		return null;
	}
}
