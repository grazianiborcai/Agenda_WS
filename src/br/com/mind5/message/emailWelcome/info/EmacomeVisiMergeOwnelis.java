package br.com.mind5.message.emailWelcome.info;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmacomeVisiMergeOwnelis implements InfoMergerVisitor_<EmacomeInfo, OwnelisInfo> {

	@Override public EmacomeInfo writeRecord(OwnelisInfo sourceOne, EmacomeInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(OwnelisInfo sourceOne, EmacomeInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmacomeInfo merge(OwnelisInfo sourceOne, EmacomeInfo sourceTwo) {
		EmacomeInfo resultInfo = makeClone(sourceTwo);
		resultInfo.ownelisData = makeClone(sourceOne);
		
		return resultInfo;
	}
	
	
	
	private EmacomeInfo makeClone(EmacomeInfo recordInfo) {
		try {
			return (EmacomeInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private OwnelisInfo makeClone(OwnelisInfo recordInfo) {
		try {
			return (OwnelisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(OwnelisInfo sourceOne, EmacomeInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
