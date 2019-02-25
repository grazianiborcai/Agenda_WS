package br.com.gda.security.tokenAuthentication.info;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.security.username.info.UsernameInfo;

final class TauthVisiMergeUsername implements InfoMergerVisitor<TauthInfo, UsernameInfo, TauthInfo> {

	@Override public TauthInfo writeRecord(UsernameInfo sourceOne, TauthInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		TauthInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(UsernameInfo sourceOne, TauthInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private TauthInfo makeClone(TauthInfo recordInfo) {
		try {
			return (TauthInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private TauthInfo merge(UsernameInfo sourceOne, TauthInfo sourceTwo) {
		sourceTwo.codUser = sourceOne.codUser;
		
		sourceTwo.authGrRoles.addAll(makeClone(sourceOne.authGrRoles));
		return sourceTwo;
	}
	
	
	
	private List<AuthGrRoleInfo> makeClone(List<AuthGrRoleInfo> recordInfos) {
		try {
			List<AuthGrRoleInfo> results = new ArrayList<>();
			
			for (AuthGrRoleInfo eachRecord : recordInfos) {
				AuthGrRoleInfo clonedRecord = (AuthGrRoleInfo) eachRecord.clone();
				results.add(clonedRecord);
			}
			
			return results;
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(UsernameInfo sourceOne, TauthInfo sourceTwo) {
		if (sourceOne.username == null ||
			sourceTwo.username == null		)
			return false;
		
		return (sourceOne.codOwner == sourceTwo.codOwner &&
				sourceOne.username.equals(sourceTwo.username));
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
