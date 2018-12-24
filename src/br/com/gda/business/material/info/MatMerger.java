package br.com.gda.business.material.info;

import java.util.List;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.info.InfoWritterFactory;

public final class MatMerger extends InfoWritterFactory<MatInfo> {	
	
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
	
	
	
	static public MatInfo merge(CurrencyInfo sourceOne, MatInfo sourceTwo) {
		return new MatMergerCurrency().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public MatInfo merge(MatUnitInfo sourceOne, MatInfo sourceTwo) {
		return new MatMergerMatUnit().merge(sourceOne, sourceTwo);
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
		
		
		if (sourceOnes.get(0) instanceof CurrencyInfo 	&&
			sourceTwos.get(0) instanceof MatInfo		)
			return new MatMergerCurrency().merge((List<CurrencyInfo>) sourceOnes, (List<MatInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof MatUnitInfo 	&&
			sourceTwos.get(0) instanceof MatInfo		)
			return new MatMergerMatUnit().merge((List<MatUnitInfo>) sourceOnes, (List<MatInfo>) sourceTwos);
		
		
		return null;
	}
}
