package br.com.gda.business.material.info;

import java.util.List;

import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.security.username.info.UsernameInfo;

public final class MatMerger extends InfoWritterFactory_<MatInfo> {	
	
	public MatMerger() {
		super(new MatUniquifier());
	}
	
	
	
	static public MatInfo merge(MatTypeInfo sourceOne, MatInfo sourceTwo) {
		return new MatMergerMatType().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public MatInfo merge(MatCategInfo sourceOne, MatInfo sourceTwo) {
		return new MatMergerMatCateg().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public MatInfo merge(MatGroupInfo sourceOne, MatInfo sourceTwo) {
		return new MatMergerMatGroup().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public MatInfo merge(MatUnitInfo sourceOne, MatInfo sourceTwo) {
		return new MatMergerMatUnit().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public MatInfo merge(UsernameInfo sourceOne, MatInfo sourceTwo) {
		return new MatMergerUsername().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public MatInfo merge(MatInfo sourceOne, MatInfo sourceTwo) {
		return new MatMergerToDelete().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public MatInfo merge(MatextInfo sourceOne, MatInfo sourceTwo) {
		return new MatMergerMatext().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<MatInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof MatTypeInfo 	&&
			sourceTwos.get(0) instanceof MatInfo		)
			return new MatMergerMatType().merge((List<MatTypeInfo>) sourceOnes, (List<MatInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof MatCategInfo 	&&
			sourceTwos.get(0) instanceof MatInfo		)
			return new MatMergerMatCateg().merge((List<MatCategInfo>) sourceOnes, (List<MatInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof MatGroupInfo 	&&
			sourceTwos.get(0) instanceof MatInfo		)
			return new MatMergerMatGroup().merge((List<MatGroupInfo>) sourceOnes, (List<MatInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof MatUnitInfo 	&&
			sourceTwos.get(0) instanceof MatInfo		)
			return new MatMergerMatUnit().merge((List<MatUnitInfo>) sourceOnes, (List<MatInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof UsernameInfo 	&&
			sourceTwos.get(0) instanceof MatInfo		)
			return new MatMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<MatInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof MatInfo	 	&&
			sourceTwos.get(0) instanceof MatInfo		)
			return new MatMergerToDelete().merge((List<MatInfo>) sourceOnes, (List<MatInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof MatextInfo 	&&
			sourceTwos.get(0) instanceof MatInfo		)
			return new MatMergerMatext().merge((List<MatextInfo>) sourceOnes, (List<MatInfo>) sourceTwos);
		
		
		return null;
	}
}
