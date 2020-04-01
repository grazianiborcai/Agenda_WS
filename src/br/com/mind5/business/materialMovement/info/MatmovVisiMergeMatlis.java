package br.com.mind5.business.materialMovement.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatmovVisiMergeMatlis implements InfoMergerVisitor_<MatmovInfo, MatlisInfo> {

	@Override public MatmovInfo writeRecord(MatlisInfo sourceOne, MatmovInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatmovInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatlisInfo sourceOne, MatmovInfo sourceTwo) {
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
	
	
	
	private MatmovInfo merge(MatlisInfo sourceOne, MatmovInfo sourceTwo) {
		sourceTwo.matlisData = sourceOne;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(MatlisInfo sourceOne, MatmovInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner	&&
				sourceOne.codMat   == sourceTwo.codMat			);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
