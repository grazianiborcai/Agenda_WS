package br.com.mind5.business.materialMovement.info;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatmovVisiMergeMatock implements InfoMergerVisitor_<MatmovInfo, MatockInfo> {

	@Override public MatmovInfo writeRecord(MatockInfo sourceOne, MatmovInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatmovInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatockInfo sourceOne, MatmovInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatmovInfo makeClone(MatmovInfo recordInfo) {
		try {
			return (MatmovInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private MatmovInfo merge(MatockInfo sourceOne, MatmovInfo sourceTwo) {
		sourceTwo.quantityStock = sourceOne.quantityStock;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(MatockInfo sourceOne, MatmovInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner	&&
				sourceOne.codMat   == sourceTwo.codMat		&&
				sourceOne.codStore == sourceTwo.codStore		);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
