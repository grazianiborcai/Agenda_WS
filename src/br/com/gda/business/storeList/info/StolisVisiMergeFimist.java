package br.com.gda.business.storeList.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.file.fileImageList.info.FimistInfo;
import br.com.gda.info.InfoMergerVisitor;

final class StolisVisiMergeFimist implements InfoMergerVisitor<StolisInfo, FimistInfo> {

	@Override public StolisInfo writeRecord(FimistInfo sourceOne, StolisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(FimistInfo sourceOne, StolisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StolisInfo merge(FimistInfo sourceOne, StolisInfo sourceTwo) {
		sourceTwo.fimistes.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(FimistInfo sourceOne, StolisInfo sourceTwo) {
		return (sourceOne.codOwner 	== sourceTwo.codOwner &&
				sourceOne.codStore 	== sourceTwo.codStore		);
	}	
}
