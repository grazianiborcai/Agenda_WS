package br.com.gda.business.materialSnapshot.info;

import java.util.List;

import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.info.InfoWritterFactory;

public final class MatSnapMerger extends InfoWritterFactory<MatSnapInfo> {	
	
	public MatSnapMerger() {
		super(new MatSnapUniquifier());
	}
	
	
	
	static public MatSnapInfo merge(MatTypeInfo sourceOne, MatSnapInfo sourceTwo) {
		return new MatSnapMergerMatType().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public MatSnapInfo merge(MatCategInfo sourceOne, MatSnapInfo sourceTwo) {
		return new MatSnapMergerMatCateg().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public MatSnapInfo merge(MatGroupInfo sourceOne, MatSnapInfo sourceTwo) {
		return new MatSnapMergerMatGroup().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public MatSnapInfo merge(MatUnitInfo sourceOne, MatSnapInfo sourceTwo) {
		return new MatSnapMergerMatUnit().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public MatSnapInfo merge(SnapInfo sourceOne, MatSnapInfo sourceTwo) {
		return new MatSnapMergerSnap().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public MatSnapInfo merge(MatInfo sourceOne, MatSnapInfo sourceTwo) {
		return new MatSnapMergerMat().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<MatSnapInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof MatTypeInfo 	&&
			sourceTwos.get(0) instanceof MatSnapInfo		)
			return new MatSnapMergerMatType().merge((List<MatTypeInfo>) sourceOnes, (List<MatSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof MatCategInfo 	&&
			sourceTwos.get(0) instanceof MatSnapInfo		)
			return new MatSnapMergerMatCateg().merge((List<MatCategInfo>) sourceOnes, (List<MatSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof MatGroupInfo 	&&
			sourceTwos.get(0) instanceof MatSnapInfo		)
			return new MatSnapMergerMatGroup().merge((List<MatGroupInfo>) sourceOnes, (List<MatSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof MatUnitInfo 	&&
			sourceTwos.get(0) instanceof MatSnapInfo		)
			return new MatSnapMergerMatUnit().merge((List<MatUnitInfo>) sourceOnes, (List<MatSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof SnapInfo 		&&
			sourceTwos.get(0) instanceof MatSnapInfo		)
			return new MatSnapMergerSnap().merge((List<SnapInfo>) sourceOnes, (List<MatSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof MatInfo 		&&
			sourceTwos.get(0) instanceof MatSnapInfo		)
			return new MatSnapMergerMat().merge((List<MatInfo>) sourceOnes, (List<MatSnapInfo>) sourceTwos);
		
		
		return null;
	}
}
